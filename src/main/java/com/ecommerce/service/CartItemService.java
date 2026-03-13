package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.CartItem;

public interface CartItemService {

    CartItem addItemToCart(Long cartId, Long productId, int quantity);

    List<CartItem> getCartItems(Long cartId);

    CartItem updateQuantity(Long cartItemId, int quantity);

    void removeItem(Long cartItemId);

}