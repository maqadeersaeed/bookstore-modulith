package com.qadeersaeed.bookstore.modules.catalog.web.dto;

import java.math.BigDecimal;

public record BookResponse(
        Long id,
        String title,
        String author,
        BigDecimal price,
        String isbn
) {}
