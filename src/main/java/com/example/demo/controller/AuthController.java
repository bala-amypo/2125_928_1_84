package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
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

    /**
     * Dummy registration endpoint (as per project requirement)
     */
    @PostMapping("/register")
    public ResponseEntity<String> register() {
        return ResponseEntity.ok("User registered");
    }

    /**
     * LOGIN – CORRECT IMPLEMENTATION
     * Uses POST + @RequestBody (industry standard)
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        String token = jwtTokenProvider.generateToken(
                request.getEmail(),
                "USER",
                1L
        );

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setEmail(request.getEmail());
        response.setRole("USER");
        response.setUserId(1L);

        return ResponseEntity.ok(response);
    }
}
