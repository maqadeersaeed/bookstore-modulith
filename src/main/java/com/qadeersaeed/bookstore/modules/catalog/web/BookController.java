package com.qadeersaeed.bookstore.modules.catalog.web;

import com.qadeersaeed.bookstore.modules.catalog.internal.BookService;
import com.qadeersaeed.bookstore.modules.catalog.web.dto.BookRequest;
import com.qadeersaeed.bookstore.modules.catalog.web.dto.BookResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public BookResponse addBook(@RequestBody BookRequest request) {
        return service.addBook(request);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public List<BookResponse> listBooks() {
        return service.listAll();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable Long id) {
        return service.findBookById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }
}
