package com.qadeersaeed.bookstore.modules.inventory.internal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId; // FK to catalog module
    private int quantity;

    public InventoryItem() {}

    public InventoryItem(Long bookId, int quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

}
