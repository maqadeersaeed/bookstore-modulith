package com.qadeersaeed.bookstore.modules.catalog.events;

import com.qadeersaeed.bookstore.common.events.BaseEvent;

public class BookAddedEvent extends BaseEvent {
    private final Long bookId;

    public BookAddedEvent(Long bookId) {
        super();
        this.bookId = bookId;
    }

    public Long bookId() {
        return bookId;
    }
}
