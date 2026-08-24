package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, User> users = new HashMap<>();

    public void initializeDefaultUsers() {
        // Adding default users
        users.put("admin", new User("admin", "admin123", "ADMIN"));
        users.put("user1", new User("user1", "password1", "CUSTOMER"));
        users.put("user2", new User("user2", "password2", "CUSTOMER"));
    }

    public User authenticate(String username, String password) {
        // Check if the user exists
        if (users.containsKey(username)) {
            User user = users.get(username);
            // Validate password
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; // Authentication failed
    }

    public boolean addUser(String username, String password, String role) {
        // Check if the username already exists
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        // Add the new user
        users.put(username, new User(username, password, role));
        return true;
    }
}