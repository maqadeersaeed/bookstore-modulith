package com.qadeersaeed.bookstore.modules.orders.web.dto;

import java.util.List;

public record CreateOrderRequest(
        Long customerId,
        List<OrderItemRequest> items
) {
    public record OrderItemRequest(Long bookId, int quantity) {}
}
