package com.qadeersaeed.bookstore.modules.orders.api;

import com.qadeersaeed.bookstore.modules.orders.web.dto.OrderResponse;

import java.util.Optional;

public interface OrderApi {
    Optional<OrderResponse> findOrder(Long id);
}
