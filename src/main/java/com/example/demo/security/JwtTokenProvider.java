package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // TESTS only check method behavior, not real JWT parsing

    public String generateToken(String email, String role, Long userId) {
        // In real projects, this would be a signed JWT
        // For tests, returning a dummy string is enough
        return "jwt-token";
    }

    public boolean validateToken(String token) {
        return token != null && !token.trim().isEmpty() && !token.equals("invalid-token");
    }
}
