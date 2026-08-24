package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> users;

    public UserService() {
        // Initialize users map and add sample users
        users = new HashMap<>();
        users.put("employee1", new User("employee1", "password123", "EMPLOYEE"));
        users.put("account1001", new User("account1001", "chequeuser", "ACCOUNT_HOLDER"));
        users.put("account1002", new User("account1002", "securepass", "ACCOUNT_HOLDER"));
    }

    public void registerUser(String username, String password, String role) {
        // Register a new user
        if (users.containsKey(username)) {
            System.out.println("User with username '" + username + "' already exists.");
            return;
        }
        users.put(username, new User(username, password, role));
        System.out.println("User '" + username + "' registered successfully with role '" + role + "'.");
    }

    public User authenticate(String username, String password) {
        // Authenticate a user
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Authentication successful for user: " + username);
            return user;
        }
        System.out.println("Authentication failed for user: " + username);
        return null;
    }
}