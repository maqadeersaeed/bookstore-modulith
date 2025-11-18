package com.qadeersaeed.bookstore.common.events;

import java.util.Map;

/**
 * To learn observability and event tracing
 * @param message
 * @param module
 * @param details
 */
public record DebugEvent(
        String message,
        String module,
        Map<String, Object> details
) {}
