package com.tw.codeavengers.tradeawayapi.service;

import com.tw.codeavengers.tradeawayapi.model.Order;
import com.tw.codeavengers.tradeawayapi.repositories.OrderRepository;
import com.tw.codeavengers.tradeawayapi.web.order.OrderRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderServiceImpl orderService;

    OrderRequest orderRequest;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(orderService);
        orderRequest = new OrderRequest("seller", "buyer", 1, "address", "item");
    }

    @Test
    public void shouldSaveTheOrder(){
        orderService.placeOrder(orderRequest);

        verify(orderRepository, times(1)).save(OrderConverter.convert(orderRequest));
    }
}