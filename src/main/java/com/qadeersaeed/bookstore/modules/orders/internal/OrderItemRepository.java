package com.qadeersaeed.bookstore.modules.orders.internal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}