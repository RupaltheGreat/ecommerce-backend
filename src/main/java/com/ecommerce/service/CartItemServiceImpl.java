package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.CartItem;
import com.ecommerce.repository.CartItemRepository;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem addItemToCart(Long cartId, Long productId, int quantity) {

        CartItem item = new CartItem();
        item.setCartId(cartId);
        item.setProductId(productId);
        item.setQuantity(quantity);

        return cartItemRepository.save(item);
    }

    @Override
    public List<CartItem> getCartItems(Long cartId) {

        return cartItemRepository.findAll()
                .stream()
                .filter(item -> item.getCartId().equals(cartId))
                .toList();
    }

    @Override
    public CartItem updateQuantity(Long cartItemId, int quantity) {

        CartItem item = cartItemRepository.findById(cartItemId).orElse(null);

        if(item != null) {
            item.setQuantity(quantity);
            return cartItemRepository.save(item);
        }

        return null;
    }

    @Override
    public void removeItem(Long cartItemId) {

        cartItemRepository.deleteById(cartItemId);

    }
}