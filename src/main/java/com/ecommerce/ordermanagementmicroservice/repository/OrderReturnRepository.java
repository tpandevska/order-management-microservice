package com.ecommerce.ordermanagementmicroservice.repository;

import com.ecommerce.ordermanagementmicroservice.model.OrderReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderReturnRepository extends JpaRepository<OrderReturn, Long> {
}
