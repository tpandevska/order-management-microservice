package com.ecommerce.ordermanagementmicroservice.common;

import com.ecommerce.ordermanagementmicroservice.model.Order;
import com.ecommerce.ordermanagementmicroservice.model.OrderItem;
import com.ecommerce.ordermanagementmicroservice.model.enums.OrderStatus;
import com.ecommerce.ordermanagementmicroservice.model.enums.PaymentStatus;

import java.util.List;

public class Generator {

    public static Order generateOrder() {
        Order order = new Order();

        order.setOrderId(Constants.ORDER_ID);
        order.setUserId(Constants.USER_ID);
        order.setOrderDate(Constants.ORDER_DATE);
        order.setOrderStatus(OrderStatus.PROCESSING);
        order.setBillingAddress(Constants.BILLING_ADDRESS);
        order.setTotalPrice(Constants.TOTAL_PRICE);
        order.setPaymentMethod(Constants.PAYMENT_METHOD);
        order.setOrderItems(List.of(generateOrderItem()));
        order.setSubTotal(Constants.SUBTOTAL);
        order.setTaxAmount(Constants.TAX_AMOUNT);
        order.setTrackingNumber(Constants.TRACKING_NUMBER);
        order.setPaymentStatus(PaymentStatus.AUTHORIZED);
        order.setOrderNotes(Constants.ORDER_NOTES);
        order.setLastUpdatedDate(Constants.LAST_UPDATED_DATE);
        order.setDiscountsOrPromotions(List.of(Constants.DISCOUNT, Constants.PROMOTION));
        order.setOrderReturn(null);

        return order;
    }

    private static OrderItem generateOrderItem() {
        OrderItem orderItem = new OrderItem();

        orderItem.setOrderItemId(Constants.ORDER_ID);
        orderItem.setProductId(Constants.ORDER_ID);
        orderItem.setQuantity(1);
        orderItem.setPrice(0.0);

        return orderItem;
    }
}