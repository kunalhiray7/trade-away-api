package com.tw.codeavengers.tradeawayapi.service;

import com.tw.codeavengers.tradeawayapi.model.Order;
import com.tw.codeavengers.tradeawayapi.web.order.OrderRequest;

import java.util.Date;

public class OrderConverter {
    public static Order convert(OrderRequest orderRequest){
        return new Order(orderRequest.getSellerName(), orderRequest.getBuyerName(), orderRequest.getQuantity(), orderRequest.getItemName(), orderRequest.getDeliveryAddress(), new Date());
    }
}
