package com.qadeersaeed.bookstore.modules.notification.internal;

import com.qadeersaeed.bookstore.modules.orders.events.OrderPlacedEvent;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendOrderConfirmation(OrderPlacedEvent event) {
        System.out.println("\n=============================");
        System.out.println("📨 Sending Order Notification");
        System.out.println("Order ID : " + event.orderId());
        System.out.println("Customer : " + event.customerId());
        System.out.println("Items:");
        event.items().forEach(item ->
                System.out.println("- Book " + item.bookId() +
                        " (qty: " + item.quantity() + ")")
        );
        System.out.println("=============================\n");
    }
}
