package com.tw.codeavengers.tradeawayapi.web.registration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tw.codeavengers.tradeawayapi.service.RegistrationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

    @Mock
    RegistrationService registrationService;

    @InjectMocks
    RegistrationController registrationController;

    MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS);
        objectMapper.disable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS);
    }

    @Test
    public void shouldRegisterTheUser() throws Exception {

        RegistrationRequest registrationRequest = new RegistrationRequest("John", "J@G.com", "john",
                "abc@123", "Gachibowli, Hyderabad", 9665173207L, UserType.BUYER, Gender.FEMALE,
                LocalDate.now(), "AFDPH0016D", 4,3);
        Mockito.when(registrationService.register(registrationRequest.mapToUser())).thenReturn(registrationRequest.mapToUser());

        String content = objectMapper.writeValueAsString(registrationRequest);
        System.out.println("CONTENT:::" + content);
        mockMvc.perform(post("/public/register").content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(registrationService, times(1)).register(registrationRequest.mapToUser());

    }

    @Test
    public void shouldReturnBadRequestWhenRequestBodyIsNotValid() throws Exception {
        RegistrationRequest registrationRequest = new RegistrationRequest(null, "J@G.com", "john",
                "abc@123", "Gachibowli, Hyderabad", 9665173207L, UserType.BUYER, Gender.FEMALE,
                LocalDate.now(), "ABCD1234D", 4,3);

        String content = objectMapper.writeValueAsString(registrationRequest);
        System.out.println("CONTENT:::" + content);
        mockMvc.perform(post("/public/register").content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}