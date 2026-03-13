package com.ecommerce.service;

import com.ecommerce.entity.Cart;

public interface CartService {

    Cart createCart(Long userId);

    Cart getCartByUserId(Long userId);

}