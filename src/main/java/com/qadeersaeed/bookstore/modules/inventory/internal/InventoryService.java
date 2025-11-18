package com.qadeersaeed.bookstore.modules.inventory.internal;

import com.qadeersaeed.bookstore.modules.inventory.api.InventoryApi;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService implements InventoryApi {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public int getStock(Long bookId) {
        return repository.findByBookId(bookId)
                .map(InventoryItem::getQuantity)
                .orElse(0);
    }

    @Override
    public boolean reduceStock(Long bookId, int quantity) {
        Optional<InventoryItem> itemOpt = repository.findByBookId(bookId);

        if (itemOpt.isEmpty()) return false;

        InventoryItem item = itemOpt.get();

        if (item.getQuantity() < quantity) return false;

        item.setQuantity(item.getQuantity() - quantity);
        repository.save(item);

        return true;
    }

    @Override
    public void addStock(Long bookId, int quantity) {
        InventoryItem item = repository.findByBookId(bookId)
                .orElse(new InventoryItem(bookId, 0));

        item.setQuantity(item.getQuantity() + quantity);
        repository.save(item);
    }
}
