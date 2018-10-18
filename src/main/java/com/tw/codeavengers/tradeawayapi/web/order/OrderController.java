package com.tw.codeavengers.tradeawayapi.web.order;

import com.tw.codeavengers.tradeawayapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping
    public void createOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
    }

}
