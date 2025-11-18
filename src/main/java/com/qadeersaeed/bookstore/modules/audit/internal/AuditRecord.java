package com.qadeersaeed.bookstore.modules.audit.internal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AuditRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String userId;

    private String action;
    private String moduleName;
    private Long entityId;
    String entity;

    public AuditRecord() {}

    public AuditRecord(String userId, String action, String moduleName, Long entityId, String entity) {
        this.userId = userId;
        this.action = action;
        this.moduleName = moduleName;
        this.entityId = entityId;
        this.entity = entity;
    }
}
