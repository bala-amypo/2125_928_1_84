package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtTokenProvider;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth Controller")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register() {
        return ResponseEntity.ok("User registered");
    }

    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestParam String email,
            @RequestParam String password
    ) {

        String token = jwtTokenProvider.generateToken(
                email,
                "USER",
                1L
        );

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setEmail(email);
        response.setRole("USER");
        response.setUserId(1L);

        return ResponseEntity.ok(response);
    }
}
