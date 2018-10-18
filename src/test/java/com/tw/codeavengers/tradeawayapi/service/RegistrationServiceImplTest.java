package com.tw.codeavengers.tradeawayapi.service;

import com.tw.codeavengers.tradeawayapi.model.User;
import com.tw.codeavengers.tradeawayapi.repositories.UserRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RegistrationServiceImpl registrationService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(registrationService);
    }

    @Test
    public void shouldSaveUser(){
        User user = new User();
        when(userRepository.findOne(anyString())).thenReturn(null);

        registrationService.register(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void shouldThrowFieldValidaionExceptionIfUserNameAlreadyExists(){
        User user = new User();
        when(userRepository.findOne(anyString())).thenReturn(user);

        expectedException.expect(FieldValidationException.class);
        expectedException.expectMessage("Username already exists");
        registrationService.register(user);
        verify(userRepository, times(0)).save(user);
    }

}