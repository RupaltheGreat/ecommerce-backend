package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.entity.Cart;
import com.ecommerce.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/create/{userId}")
    public Cart createCart(@PathVariable Long userId) {
        return cartService.createCart(userId);
    }

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }
}