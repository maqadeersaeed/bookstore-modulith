package com.qadeersaeed.bookstore.modules.inventory.web;

import com.qadeersaeed.bookstore.modules.inventory.api.InventoryApi;
import com.qadeersaeed.bookstore.modules.inventory.web.dto.StockResponse;
import com.qadeersaeed.bookstore.modules.inventory.web.dto.UpdateStockRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryApi inventoryApi;

    public InventoryController(InventoryApi inventoryApi) {
        this.inventoryApi = inventoryApi;
    }

    @GetMapping("/{bookId}")
    public StockResponse getStock(@PathVariable Long bookId) {
        return new StockResponse(bookId, inventoryApi.getStock(bookId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{bookId}/add")
    public StockResponse addStock(@PathVariable Long bookId,
                                  @RequestBody UpdateStockRequest req) {
        inventoryApi.addStock(bookId, req.quantity());
        return getStock(bookId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{bookId}/reduce")
    public StockResponse reduceStock(@PathVariable Long bookId,
                                     @RequestBody UpdateStockRequest req) {
        inventoryApi.reduceStock(bookId, req.quantity());
        return getStock(bookId);
    }
}
