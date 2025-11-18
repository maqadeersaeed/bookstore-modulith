package com.qadeersaeed.bookstore.modules.audit.internal;

import com.qadeersaeed.bookstore.common.events.AuditEvent;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    private final AuditRepository repo;

    public AuditService(AuditRepository repo) {
        this.repo = repo;
    }

    public void save(AuditEvent event) {
        repo.save(new AuditRecord(
                event.getUserId(),
                event.getAction(),
                event.getModuleName(),
                event.getEntityId(),
                event.getEntity()
        ));
    }
}
