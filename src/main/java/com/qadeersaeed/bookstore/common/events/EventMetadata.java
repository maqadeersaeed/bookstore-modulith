package com.qadeersaeed.bookstore.common.events;

public record EventMetadata(
        String sourceModule,
        String traceId,
        String userId
) {}
