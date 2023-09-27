package com.ecommerce.ordermanagementmicroservice.service;

import com.ecommerce.ordermanagementmicroservice.model.Order;
import com.ecommerce.ordermanagementmicroservice.model.OrderItem;
import com.ecommerce.ordermanagementmicroservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    /**
     * Constructor for OrderService
     *
     * @param orderRepository : order repository
     */
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Fetches the already existing order by its id
     *
     * @param orderId : The id of the order that we are trying to fetch
     * @return Optional of the fetched order
     */
    public Optional<Order> findOrderById(Long orderId) {
        return this.orderRepository.findById(orderId);
    }

    /**
     * Creates new order
     *
     * @param order : The new order along with needed properties
     * @return Optional of the newly created order
     */
    public Optional<Order> createOrder(Order order) {
        List<OrderItem> orderItems = new ArrayList<>();

        if(order.getOrderItems() != null) {
            for (OrderItem item: order.getOrderItems()) {
                item.setOrder(order);
                orderItems.add(item);
            }

            order.setOrderItems(orderItems);
        }

        return Optional.of(this.orderRepository.save(order));
    }
}