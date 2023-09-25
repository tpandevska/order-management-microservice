package com.ecommerce.ordermanagementmicroservice.model;

import com.ecommerce.ordermanagementmicroservice.model.enums.OrderStatus;
import com.ecommerce.ordermanagementmicroservice.model.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long userId;

    private LocalDateTime orderDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.PENDING;

    private String billingAddress;

    private Double totalPrice;

    private String paymentMethod;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderItem> orderItems;

    private Double subTotal;

    private Integer taxAmount;

    private Long trackingNumber;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    private String orderNotes;

    private LocalDateTime lastUpdatedDate = LocalDateTime.now();

    @ElementCollection
    private List<String> discountsOrPromotions;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private OrderReturn orderReturn;

    //TODO: add additional fields later: order history, customer feedback, shipping carrier details etc.
}
