package com.qadeersaeed.bookstore.modules.audit.listeners;

import com.qadeersaeed.bookstore.common.events.AuditEvent;
import com.qadeersaeed.bookstore.modules.audit.internal.AuditService;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
public class AuditEventListener {

    private final AuditService service;

    public AuditEventListener(AuditService service) {
        this.service = service;
    }

    @ApplicationModuleListener
    public void on(AuditEvent event) {
        service.save(event);
    }
}
