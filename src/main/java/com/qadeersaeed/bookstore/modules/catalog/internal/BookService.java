package com.qadeersaeed.bookstore.modules.catalog.internal;

import com.qadeersaeed.bookstore.common.events.AuditEvent;
import com.qadeersaeed.bookstore.common.events.EntityCreatedEvent;
import com.qadeersaeed.bookstore.modules.catalog.api.BookCatalogApi;
import com.qadeersaeed.bookstore.modules.catalog.events.BookAddedEvent;
import com.qadeersaeed.bookstore.modules.catalog.web.dto.BookRequest;
import com.qadeersaeed.bookstore.modules.catalog.web.dto.BookResponse;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookCatalogApi {

    private final BookRepository repository;
    private final ApplicationEventPublisher publisher;

    public BookService(BookRepository repository, ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public BookResponse addBook(BookRequest request) {
        Book book = new Book(
                request.title(),
                request.author(),
                request.price(),
                request.isbn()
        );

        Book saved = repository.save(book);

        // Publish event
        publisher.publishEvent(new BookAddedEvent(saved.getId()));
        publisher.publishEvent(new EntityCreatedEvent("Book", saved.getId()));
        publisher.publishEvent(new AuditEvent("user1","CREATE", "catalog", saved.getId(), Book.class.getName()));

        return BookMapper.toResponse(saved);
    }

    public List<BookResponse> listAll() {
        return repository.findAll()
                .stream()
                .map(BookMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<BookResponse> findBookById(Long id) {
        return repository.findById(id)
                .map(BookMapper::toResponse);
    }
}
