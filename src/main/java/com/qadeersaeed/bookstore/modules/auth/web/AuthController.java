package com.qadeersaeed.bookstore.modules.auth.web;

import com.qadeersaeed.bookstore.modules.auth.internal.AuthService;
import com.qadeersaeed.bookstore.modules.auth.web.dto.AuthRequest;
import com.qadeersaeed.bookstore.modules.auth.web.dto.AuthResponse;
import com.qadeersaeed.bookstore.modules.auth.web.dto.RegisterRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return service.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return service.login(request);
    }

    @GetMapping("/validate")
    public boolean validateToken(@RequestHeader("Authorization") String authHeader) {
        return service.validate(authHeader);
    }
}
