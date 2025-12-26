package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.payload.AuthRequest;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtTokenProvider;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService,
                          JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest request) {
        String token = jwtTokenProvider.generateToken(request.getUsername());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return response;
    }
}
