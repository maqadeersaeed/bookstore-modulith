package com.qadeersaeed.bookstore.modules.catalog.api;

import com.qadeersaeed.bookstore.modules.catalog.web.dto.BookResponse;

import java.util.Optional;

public interface BookCatalogApi {

    Optional<BookResponse> findBookById(Long id);
}
