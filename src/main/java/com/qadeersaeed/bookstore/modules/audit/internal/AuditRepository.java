package com.qadeersaeed.bookstore.modules.audit.internal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<AuditRecord, Long> {}
