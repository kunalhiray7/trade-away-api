package com.tw.codeavengers.tradeawayapi.service;

import com.tw.codeavengers.tradeawayapi.web.order.OrderRequest;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
