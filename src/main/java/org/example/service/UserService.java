package org.example.service;

import org.example.pojo.User;

public interface UserService {
    // Find user by username
    User findByUsername(String username);

    // Register
    void register(String username, String password);
}
