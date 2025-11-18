package com.qadeersaeed.bookstore.common.events;

public class EntityDeletedEvent extends BaseEvent {

    private final String entityType;
    private final Long entityId;

    public EntityDeletedEvent(String entityType, Long entityId) {
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
