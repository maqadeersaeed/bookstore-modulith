package com.qadeersaeed.bookstore.modules.orders.web;

import com.qadeersaeed.bookstore.modules.orders.internal.OrderService;
import com.qadeersaeed.bookstore.modules.orders.web.dto.CreateOrderRequest;
import com.qadeersaeed.bookstore.modules.orders.web.dto.OrderResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping
    public OrderResponse placeOrder(@RequestBody CreateOrderRequest req) {
        return service.placeOrder(req);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public OrderResponse getOrder(@PathVariable Long id) {
        return service.getOrder(id);
    }
}
