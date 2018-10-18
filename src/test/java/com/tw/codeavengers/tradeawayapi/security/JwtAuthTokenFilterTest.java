package com.tw.codeavengers.tradeawayapi.security;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class JwtAuthTokenFilterTest {

    @Mock
    private HttpServletRequest httpServletRequest;
    @Mock
    private HttpServletResponse httpServletResponse;
    @Mock
    private FilterChain filterChain;
    @Mock
    private TokenUtils tokenUtils;

    @InjectMocks
    JwtAuthTokenFilter jwtAuthTokenFilter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(jwtAuthTokenFilter);
    }

    @Test
    public void shouldThrowExceptionWhenNoBearerTokenProvided() throws ServletException, IOException {

        Mockito.when(httpServletRequest.getHeader(anyString())).thenReturn("Bearer Garbage");
        Mockito.when(httpServletRequest.getRequestURI()).thenReturn("/api");
        Mockito.when(httpServletRequest.getMethod()).thenReturn("post");

        jwtAuthTokenFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

        Mockito.verify(httpServletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error while parsing JWT token, check logs");
    }

    @Test
    public void shouldSetAuthenticationForValidToken() throws ServletException, IOException {

        Mockito.when(httpServletRequest.getRequestURI()).thenReturn("/api");
        Mockito.when(httpServletRequest.getHeader(anyString())).thenReturn("Bearer " + "TOKEN");
        Mockito.when(httpServletRequest.getMethod()).thenReturn("post");


        Token tokenObject = new Token();
        tokenObject.setRoles("Buyer");
        tokenObject.setName("TestUser");
        tokenObject.setUserName("test");

        Mockito.when(tokenUtils.parse("TOKEN")).thenReturn(tokenObject);

        jwtAuthTokenFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

        Token principal = (Token) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Assert.assertEquals("test", principal.getUserName());
        Assert.assertEquals("TestUser", principal.getName());
        Assert.assertEquals("Buyer", principal.getRoles());
    }

    @Test
    public void shouldNotFilterIfPublicUrl() throws ServletException, IOException {

        Mockito.when(httpServletRequest.getRequestURI()).thenReturn("/public/login");
        Mockito.when(httpServletRequest.getMethod()).thenReturn("post");

        jwtAuthTokenFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

        Mockito.verifyNoMoreInteractions(tokenUtils);
    }

    @Test
    public void shouldNotFilterForOPTIONS() throws ServletException, IOException {

        Mockito.when(httpServletRequest.getRequestURI()).thenReturn("/api");
        Mockito.when(httpServletRequest.getMethod()).thenReturn("OPTIONS");

        jwtAuthTokenFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

        Mockito.verifyNoMoreInteractions(tokenUtils);
    }

}