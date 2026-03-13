package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.entity.CartItem;
import com.ecommerce.service.CartItemService;

@RestController
@RequestMapping("/api/cart/items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/add/{cartId}/{productId}/{quantity}")
    public CartItem addItem(
            @PathVariable Long cartId,
            @PathVariable Long productId,
            @PathVariable int quantity) {

        return cartItemService.addItemToCart(cartId, productId, quantity);
    }

    @GetMapping("/{cartId}")
    public List<CartItem> getItems(@PathVariable Long cartId) {

        return cartItemService.getCartItems(cartId);
    }

    @PutMapping("/update/{cartItemId}/{quantity}")
    public CartItem updateItem(
            @PathVariable Long cartItemId,
            @PathVariable int quantity) {

        return cartItemService.updateQuantity(cartItemId, quantity);
    }

    @DeleteMapping("/remove/{cartItemId}")
    public String removeItem(@PathVariable Long cartItemId) {

        cartItemService.removeItem(cartItemId);

        return "Item removed from cart";
    }
}