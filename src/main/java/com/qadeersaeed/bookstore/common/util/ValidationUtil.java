package com.qadeersaeed.bookstore.common.util;

public class ValidationUtil {

    public static void require(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }
}
