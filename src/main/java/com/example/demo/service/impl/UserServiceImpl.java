package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User saveUser(User user) {
        // DB logic later
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = new User();
        user.setEmail(email);
        user.setUsername("dummy");
        user.setPassword("dummy");
        return user;
    }
}
