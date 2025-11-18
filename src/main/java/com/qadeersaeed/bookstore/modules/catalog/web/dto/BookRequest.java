package com.qadeersaeed.bookstore.modules.catalog.web.dto;

import java.math.BigDecimal;

public record BookRequest(
        String title,
        String author,
        BigDecimal price,
        String isbn
) {}