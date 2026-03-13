package com.ecommerce.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.CartItem;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.repository.CartItemRepository;
import com.ecommerce.repository.OrderItemRepository;
import com.ecommerce.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Order checkout(Long userId, Long cartId) {

        List<CartItem> cartItems = cartItemRepository.findAll()
                .stream()
                .filter(item -> item.getCartId().equals(cartId))
                .toList();

        double totalAmount = 0;

        for (CartItem item : cartItems) {
            totalAmount += item.getQuantity() * 100; 
         // simple price simulation
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(totalAmount);
        order.setOrderDate(LocalDateTime.now());

        Random random = new Random();
        boolean paymentSuccess = random.nextBoolean();

        if (paymentSuccess) {
            order.setPaymentStatus("SUCCESS");
            order.setOrderStatus("PLACED");
        } else {
            order.setPaymentStatus("FAILED");
            order.setOrderStatus("CANCELLED");
        }

        Order savedOrder = orderRepository.save(order);

        for (CartItem item : cartItems) {

            OrderItem orderItem = new OrderItem();

            orderItem.setOrderId(savedOrder.getId());
            orderItem.setProductId(item.getProductId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(100);

            orderItemRepository.save(orderItem);
        }

        cartItemRepository.deleteAll(cartItems);

        return savedOrder;
    }
}