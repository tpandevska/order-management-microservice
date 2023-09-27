package com.ecommerce.ordermanagementmicroservice.web;


import com.ecommerce.ordermanagementmicroservice.model.Order;
import com.ecommerce.ordermanagementmicroservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    private final OrderService orderService;

    /**
     * Constructor for OrderRestController
     *
     * @param orderService : order service
     */
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Finds existing order by its id
     *
     * @param orderId : the id of the needed order passed as a path variable
     * @return Response Entity : response
     */
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> findOrderById(@PathVariable Long orderId) {
        return this.orderService.findOrderById(orderId)
                .map(order -> ResponseEntity.ok().body(order))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates new order
     *
     * @param order : the new order passed in RequestBody
     * @return ResponseEntity : response
     */
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return this.orderService.createOrder(order)
                .map(o -> ResponseEntity.ok().body(order))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}