package com.ecommerce.service;

import com.ecommerce.entity.Order;

public interface OrderService {

    Order checkout(Long userId, Long cartId);

}