package com.qadeersaeed.bookstore.modules.inventory.api;

public interface InventoryApi {

    int getStock(Long bookId);

    boolean reduceStock(Long bookId, int quantity);

    void addStock(Long bookId, int quantity);
}
