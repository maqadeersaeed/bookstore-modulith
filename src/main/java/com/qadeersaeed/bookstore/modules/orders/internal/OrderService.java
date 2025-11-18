package com.qadeersaeed.bookstore.modules.orders.internal;

import com.qadeersaeed.bookstore.common.events.AuditEvent;
import com.qadeersaeed.bookstore.common.events.EntityCreatedEvent;
import com.qadeersaeed.bookstore.modules.catalog.internal.Book;
import com.qadeersaeed.bookstore.modules.inventory.api.InventoryApi;
import com.qadeersaeed.bookstore.modules.orders.events.OrderPlacedEvent;
import com.qadeersaeed.bookstore.modules.orders.web.dto.CreateOrderRequest;
import com.qadeersaeed.bookstore.modules.orders.web.dto.OrderResponse;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepo;
    private final InventoryApi inventoryApi;
    private final ApplicationEventPublisher publisher;

    public OrderService(OrderRepository orderRepo, InventoryApi inventoryApi,
                        ApplicationEventPublisher publisher) {
        this.orderRepo = orderRepo;
        this.inventoryApi = inventoryApi;
        this.publisher = publisher;
    }

    public OrderResponse placeOrder(CreateOrderRequest request) {

        // Validate inventory for each book
        for (var item : request.items()) {
            int stock = inventoryApi.getStock(item.bookId());
            if (stock < item.quantity()) {
                throw new RuntimeException("Not enough stock for book " + item.bookId());
            }
        }

        // Reduce stock
        for (var item : request.items()) {
            inventoryApi.reduceStock(item.bookId(), item.quantity());
        }

        // Save order
        Order order = new Order(request.customerId());
        request.items().forEach(i -> order.addItem(new OrderItem(i.bookId(), i.quantity())));

        Order saved = orderRepo.save(order);

        // Publish event
        publisher.publishEvent(new OrderPlacedEvent(
                saved.getId(),
                saved.getCustomerId(),
                saved.getItems()
                        .stream()
                        .map(i -> new OrderPlacedEvent.OrderItemPayload(i.getBookId(), i.getQuantity()))
                        .collect(Collectors.toList())
        ));

        publisher.publishEvent(new EntityCreatedEvent("Order", saved.getId()));
        publisher.publishEvent(new AuditEvent("user1","CREATE", "orders", saved.getId(), Order.class.getName()));


        return OrderMapper.toResponse(saved);
    }

    public OrderResponse getOrder(Long id) {
        return orderRepo.findById(id)
                .map(OrderMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
