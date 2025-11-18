package com.qadeersaeed.bookstore.modules.catalog.internal;

import com.qadeersaeed.bookstore.modules.catalog.web.dto.BookResponse;

public class BookMapper {

    public static BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getIsbn()
        );
    }
}
