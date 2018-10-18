package com.tw.codeavengers.tradeawayapi.service;

import com.tw.codeavengers.tradeawayapi.model.Order;
import com.tw.codeavengers.tradeawayapi.repositories.OrderRepository;
import com.tw.codeavengers.tradeawayapi.web.order.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void placeOrder(OrderRequest order) {
        orderRepository.save(OrderConverter.convert(order));
    }
}
