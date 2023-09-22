package com.ecommerce.ordermanagementmicroservice.repository;

import com.ecommerce.ordermanagementmicroservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
