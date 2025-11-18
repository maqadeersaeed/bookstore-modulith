package com.qadeersaeed.bookstore.common.events;

public record PaymentProcessedEvent(
        Long orderId,
        String paymentStatus
) {}
