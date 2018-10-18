package com.tw.codeavengers.tradeawayapi.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationEntryPointTest {

    @Mock
    HttpServletResponse httpServletResponse;
    @Mock
    HttpServletRequest httpServletRequest;

    @Test
    public void shouldSendErrorWith401() throws IOException, ServletException {
        AuthenticationEntryPoint authenticationEntryPoint = new AuthenticationEntryPoint();

        AuthenticationException authenticationException = new BadCredentialsException("Bad Cred");

        authenticationEntryPoint.commence(httpServletRequest, httpServletResponse, authenticationException);

        Mockito.verify(httpServletResponse, Mockito.times(1)).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");

    }

}