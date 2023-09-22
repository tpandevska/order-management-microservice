package com.ecommerce.ordermanagementmicroservice.service;

import com.ecommerce.ordermanagementmicroservice.model.Order;
import com.ecommerce.ordermanagementmicroservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> findOrderById(Long orderId) {
        return this.orderRepository.findById(orderId);
    }
}