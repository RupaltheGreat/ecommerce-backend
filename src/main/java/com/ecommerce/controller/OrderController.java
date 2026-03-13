package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.entity.Order;
import com.ecommerce.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout/{userId}/{cartId}")
    public Order checkout(
            @PathVariable Long userId,
            @PathVariable Long cartId) {

        return orderService.checkout(userId, cartId);
    }
}