package com.qadeersaeed.bookstore.modules.orders.internal;

import com.qadeersaeed.bookstore.modules.orders.web.dto.OrderResponse;

import java.util.stream.Collectors;

public class OrderMapper {
    public static OrderResponse toResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getCustomerId(),
                order.getItems()
                        .stream()
                        .map(i -> new OrderResponse.OrderItemResponse(i.getBookId(), i.getQuantity()))
                        .collect(Collectors.toList())
        );
    }
}
