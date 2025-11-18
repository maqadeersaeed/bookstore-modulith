package com.qadeersaeed.bookstore.common.events;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public abstract class BaseEvent implements Serializable {

    private final String eventId;
    private final Instant timestamp;

    protected BaseEvent() {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = Instant.now();
    }

    public String getEventId() {
        return eventId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getEventType() {
        return this.getClass().getSimpleName();
    }
}
