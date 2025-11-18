package com.qadeersaeed.bookstore.modules.notification.listeners;

import com.qadeersaeed.bookstore.modules.notification.internal.NotificationService;
import com.qadeersaeed.bookstore.modules.orders.events.OrderPlacedEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OrderPlacedEventListener {

    private final NotificationService notificationService;

    public OrderPlacedEventListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Async
    @ApplicationModuleListener()
    public void on(OrderPlacedEvent event) {
        notificationService.sendOrderConfirmation(event);
    }
}
