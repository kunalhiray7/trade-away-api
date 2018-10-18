package com.tw.codeavengers.tradeawayapi.service;

import com.tw.codeavengers.tradeawayapi.model.User;
import com.tw.codeavengers.tradeawayapi.repositories.UserRepository;
import com.tw.codeavengers.tradeawayapi.security.Token;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.authentication.BadCredentialsException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    LoginServiceImpl loginService;


    @Test(expected = BadCredentialsException.class)
    public void shouldThrowExceptionIfUserNotFound() {
        when(userRepository.findOne("username")).thenReturn(null);

        loginService.login("username", "password");

        verify(userRepository, times(1)).findOne("username");
    }

    @Test(expected = BadCredentialsException.class)
    public void shouldThrowExceptionIfUserFoundButPasswordDidNotMatch() {
        when(userRepository.findOne("username")).thenReturn(null);

        loginService.login("username", "password");

        verify(userRepository, times(1)).findOne("username");
    }

    @Test
    public void shouldReturnTokenIfUserCredentialsAreCorrect() {
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setName("TestUser");
        user.setRole("Buyer");
        when(userRepository.findOne("username")).thenReturn(user);

        Token token = loginService.login("username", "password");
        assertEquals(user.getUsername(), token.getUserName());
        assertEquals(user.getName(), token.getName());
        assertEquals(user.getRole(), token.getRoles());

    }

}