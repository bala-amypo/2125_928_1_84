package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User register(String email, String password, String role) {
        User u = new User();
        u.setEmail(email);
        u.setPassword(password);
        u.setRole(role);
        return repo.save(u);
    }

    public String login(String email, String password) {
        return "dummy-token";
    }
}
