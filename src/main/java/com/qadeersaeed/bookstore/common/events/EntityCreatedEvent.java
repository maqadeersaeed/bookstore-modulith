package com.qadeersaeed.bookstore.common.events;

public class EntityCreatedEvent extends BaseEvent {

    private final String entityType;
    private final Long entityId;

    public EntityCreatedEvent(String entityType, Long entityId) {
        this.entityType = entityType;
        this.entityId = entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public Long getEntityId() {
        return entityId;
    }
}
