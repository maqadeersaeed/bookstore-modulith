package com.qadeersaeed.bookstore.common.events;

public record TenantAwareEvent(
        Long tenantId,
        Object innerEvent
) {}
