package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Simple save method (for testing & JWT flow)
    public User saveUser(User user) {
        // In real project → save to DB
        return user;
    }

    public User findByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword("dummy-password");
        return user;
    }
}
