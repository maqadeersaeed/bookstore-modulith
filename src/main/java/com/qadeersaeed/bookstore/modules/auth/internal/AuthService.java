package com.qadeersaeed.bookstore.modules.auth.internal;

import com.qadeersaeed.bookstore.common.events.AuditEvent;
import com.qadeersaeed.bookstore.common.exceptions.BadRequestException;
import com.qadeersaeed.bookstore.modules.auth.web.dto.AuthRequest;
import com.qadeersaeed.bookstore.modules.auth.web.dto.AuthResponse;
import com.qadeersaeed.bookstore.modules.auth.web.dto.RegisterRequest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ApplicationEventPublisher publisher;

    public AuthService(UserRepository userRepo,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService,
                       ApplicationEventPublisher publisher) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.publisher = publisher;
    }

    public AuthResponse register(RegisterRequest request) {
        userRepo.findByUsername(request.username()).ifPresent(u -> {
            throw new BadRequestException("Username already taken");
        });

        User user = new User(
                request.username(),
                passwordEncoder.encode(request.password()),
                Role.USER
        );

        User saved = userRepo.save(user);

        // audit
        publisher.publishEvent(new AuditEvent("", "REGISTER", "auth", saved.getId(), User.class.getName()));

        String token = jwtService.generateToken(saved.getUsername(), saved.getRole().name());
        return new AuthResponse(token);
    }

    public AuthResponse login(AuthRequest request) {
        User user = userRepo.findByUsername(request.username())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        // audit
        publisher.publishEvent(new AuditEvent(user.getId().toString(), "LOGIN", "auth", user.getId(), User.class.getName()));

        String token = jwtService.generateToken(user.getUsername(), user.getRole().name());
        return new AuthResponse(token);
    }

    public boolean validate(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer "))
            return false;

        String token = authHeader.substring(7);

        return jwtService.isTokenValid(token);
    }

}
