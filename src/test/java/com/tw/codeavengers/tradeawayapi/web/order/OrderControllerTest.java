package com.tw.codeavengers.tradeawayapi.web.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.codeavengers.tradeawayapi.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
    final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    OrderService orderService;

    @InjectMocks
    OrderController orderController;

    OrderRequest orderRequest;

    MockMvc mockMvc;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(orderController);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
        orderRequest = new OrderRequest("seller", "buyer", 1, "address", "item");
    }

    @Test
    public void shouldPlaceTheOrder() throws Exception {
        mockMvc.perform(post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderRequest))
        ).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());

        verify(orderService, times(1)).placeOrder(orderRequest);
    }

}