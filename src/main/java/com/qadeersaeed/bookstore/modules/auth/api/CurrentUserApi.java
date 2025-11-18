package com.qadeersaeed.bookstore.modules.auth.api;

import java.util.Optional;

public interface CurrentUserApi {
    Optional<String> getCurrentUsername();
}
