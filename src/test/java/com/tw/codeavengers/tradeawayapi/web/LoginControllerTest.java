package com.tw.codeavengers.tradeawayapi.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.codeavengers.tradeawayapi.security.Token;
import com.tw.codeavengers.tradeawayapi.security.TokenUtils;
import com.tw.codeavengers.tradeawayapi.service.LoginService;
import com.tw.codeavengers.tradeawayapi.web.login.LoginController;
import com.tw.codeavengers.tradeawayapi.web.login.LoginRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    @Mock
    LoginService loginService;

    @Mock
    TokenUtils tokenUtils;

    @InjectMocks
    LoginController loginController;

    MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @Test
    public void shouldReturnTokenForValidCredentials() throws Exception {
        String username = "username";
        String password = "password";
        String encryptedToken = "TOKEN";

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username);
        loginRequest.setPassword(password);

        Token token = new Token();
        token.setUserName(username);
        token.setName("Name");
        token.setRoles("Buyer");

        when(loginService.login(username, password)).thenReturn(token);
        when(tokenUtils.createToken(token)).thenReturn(encryptedToken);

        mockMvc.perform(post("/public/login").content(objectMapper.writeValueAsString(loginRequest)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value(encryptedToken));

        verify(loginService, times(1)).login(username, password);
    }
}