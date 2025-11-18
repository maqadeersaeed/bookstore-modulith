package com.qadeersaeed.bookstore.modules.orders.web.dto;

import java.util.List;

public record OrderResponse(
        Long orderId,
        Long customerId,
        List<OrderItemResponse> items
) {
    public record OrderItemResponse(Long bookId, int quantity) {}
}
