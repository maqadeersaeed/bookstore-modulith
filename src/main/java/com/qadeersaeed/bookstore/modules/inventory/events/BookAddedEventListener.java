package com.qadeersaeed.bookstore.modules.inventory.events;

import com.qadeersaeed.bookstore.modules.catalog.events.BookAddedEvent;
import com.qadeersaeed.bookstore.modules.inventory.internal.InventoryService;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
public class BookAddedEventListener {

    private final InventoryService service;

    public BookAddedEventListener(InventoryService service) {
        this.service = service;
    }

    @ApplicationModuleListener
    public void on(BookAddedEvent event) {
        Long bookId = event.bookId();

        // initialize stock with default quantity = 10
        service.addStock(bookId, 10);

        System.out.println("Initialized inventory for Book ID = " + bookId);
    }
}
