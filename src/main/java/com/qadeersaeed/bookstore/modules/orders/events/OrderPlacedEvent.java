package com.qadeersaeed.bookstore.modules.orders.events;

import com.qadeersaeed.bookstore.common.events.BaseEvent;

import java.util.List;

public class OrderPlacedEvent extends BaseEvent {

    private final Long orderId;
    private final Long customerId;
    private final List<OrderItemPayload> items;

    public OrderPlacedEvent(Long orderId, Long customerId, List<OrderItemPayload> items) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = items;
    }

    public Long orderId() { return orderId; }
    public Long customerId() { return customerId; }
    public List<OrderItemPayload> items() { return items; }

    public record OrderItemPayload(Long bookId, int quantity) {}
}
