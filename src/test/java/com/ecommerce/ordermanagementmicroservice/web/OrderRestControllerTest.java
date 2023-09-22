package com.ecommerce.ordermanagementmicroservice.web;

import com.ecommerce.ordermanagementmicroservice.common.Constants;
import com.ecommerce.ordermanagementmicroservice.model.Order;
import com.ecommerce.ordermanagementmicroservice.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static com.ecommerce.ordermanagementmicroservice.common.Generator.generateOrder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderRestControllerTest {

    @InjectMocks
    OrderRestController classUnderTest;

    @Mock
    OrderService orderService;

    private Order order;

    @BeforeEach
    void setUp() {
        order = generateOrder();
    }

    @Test
    void findOrderByIdSuccessfully() {
        //GIVEN
        when(orderService.findOrderById(anyLong())).thenReturn(Optional.of(order));

        //WHEN
        ResponseEntity<Order> response = classUnderTest.findOrderById(Constants.ORDER_ID);

        //THEN
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(order);
        verify(orderService, times(1)).findOrderById(Constants.ORDER_ID);
    }

    @Test
    void findOrderByIdWhenOrderDoesNotExist() {
        //GIVEN
        when(orderService.findOrderById(anyLong())).thenReturn(Optional.empty());

        //WHEN
        ResponseEntity<Order> response = classUnderTest.findOrderById(Constants.ORDER_ID);

        //THEN
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        verify(orderService, times(1)).findOrderById(Constants.ORDER_ID);
    }
}
