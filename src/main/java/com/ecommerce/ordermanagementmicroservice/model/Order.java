package com.ecommerce.ordermanagementmicroservice.model;

import com.ecommerce.ordermanagementmicroservice.model.enums.OrderStatus;
import com.ecommerce.ordermanagementmicroservice.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;

    private Long userId;

    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private String billingAddress;

    private Double totalPrice;

    private String paymentMethod;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    private Double subTotal;

    private Double taxAmount;

    private Integer trackingNumber;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private String orderNotes;

    private LocalDateTime lastUpdatedDate;

    @ElementCollection
    private List<String> discountsOrPromotions;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private OrderReturn orderReturn;

    //TODO: add additional fields later: order history, customer feedback, shipping carrier details etc.
}
