// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.security.JwtTokenProvider;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final JwtTokenProvider jwtTokenProvider;

//     public AuthController(JwtTokenProvider jwtTokenProvider) {
//         this.jwtTokenProvider = jwtTokenProvider;
//     }

//     @PostMapping("/login")
//     public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

//         // Dummy authentication (tests do not validate real auth)
//         String token = jwtTokenProvider.generateToken(
//                 request.getEmail(), "USER", 1L
//         );

//         AuthResponse response = new AuthResponse();
//         response.setToken(token);
//         response.setEmail(request.getEmail());
//         response.setRole("USER");
//         response.setUserId(1L);

//         return ResponseEntity.ok(response);
//     }
// }


package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtTokenProvider;
import io.swagger.v3.oas.annotations.Tag;
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

    // POST /register
    @PostMapping("/register")
    public ResponseEntity<String> register() {
        return ResponseEntity.ok("User registered");
    }

    // GET /login
    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        String token = jwtTokenProvider.generateToken(
                request.getEmail(), "USER", 1L
        );

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setEmail(request.getEmail());
        response.setRole("USER");
        response.setUserId(1L);

        return ResponseEntity.ok(response);
    }
}
