package com.qadeersaeed.bookstore.common.events;


public class AuditEvent extends BaseEvent {

    String userId;

    private final String action;
    private final String moduleName;
    private final Long entityId;

    String entity;

    public AuditEvent(String userId, String action, String moduleName, Long entityId, String entity) {
        this.action = action;
        this.moduleName = moduleName;
        this.entityId = entityId;
        this.entity = entity;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getAction() {
        return action;
    }

    public String getModuleName() {
        return moduleName;
    }

    public Long getEntityId() {
        return entityId;
    }

    public String getEntity() {
        return entity;
    }
}
