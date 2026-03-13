package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Cart;
import com.ecommerce.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart createCart(Long userId) {

        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setTotalPrice(0);

        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartByUserId(Long userId) {
        return cartRepository.findAll()
                .stream()
                .filter(cart -> cart.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }
}