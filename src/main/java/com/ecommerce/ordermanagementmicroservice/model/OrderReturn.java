package com.ecommerce.ordermanagementmicroservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "orderReturns")
@Data
@NoArgsConstructor
public class OrderReturn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderReturnId;

    private LocalDateTime returnRequestDate;

    private String returnStatus;

    private Double refundAmount;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
