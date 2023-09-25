package com.ecommerce.ordermanagementmicroservice.common;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class Constants {

    public static final Long ORDER_ID;

    public static final Long USER_ID;

    public static final LocalDateTime ORDER_DATE;

    public static final String BILLING_ADDRESS;

    public static final Double TOTAL_PRICE;

    public static final String PAYMENT_METHOD;

    public static final Double SUBTOTAL;

    public static final Integer TAX_AMOUNT;

    public static final Long TRACKING_NUMBER;

    public static final String ORDER_NOTES;

    public static final LocalDateTime LAST_UPDATED_DATE;

    public static final String DISCOUNT;

    public static final String PROMOTION;

    static {
        ORDER_ID = 123456L;
        USER_ID = 100000L;
        ORDER_DATE = LocalDateTime.now();
        BILLING_ADDRESS = "Dummy billing address";
        TOTAL_PRICE = 100.00;
        PAYMENT_METHOD = "Credit card";
        SUBTOTAL = 82.00;
        TAX_AMOUNT = 18;
        TRACKING_NUMBER = 1234L;
        ORDER_NOTES = "Dummy order notes";
        LAST_UPDATED_DATE = LocalDateTime.now();
        DISCOUNT = "discount";
        PROMOTION = "promotion";
    }
}