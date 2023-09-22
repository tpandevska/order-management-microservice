package com.ecommerce.ordermanagementmicroservice.service;

import com.ecommerce.ordermanagementmicroservice.common.Constants;
import com.ecommerce.ordermanagementmicroservice.model.Order;
import com.ecommerce.ordermanagementmicroservice.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.ecommerce.ordermanagementmicroservice.common.Generator.generateOrder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    OrderService classUnderTest;

    @Mock
    OrderRepository orderRepository;

    private Order order;

    @BeforeEach
    public void setUp() {
        order = generateOrder();
    }

    @Test
    void findOrderByIdSuccessfully() {
        //GIVEN
        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(order));

        //WHEN
        Order result = classUnderTest.findOrderById(Constants.ORDER_ID).get();

        //THEN
        assertThat(result).isEqualTo(order);
        verify(orderRepository, times(1)).findById(Constants.ORDER_ID);
    }
}