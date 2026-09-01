package com.example.demo;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    public boolean authenticate(String username, String password) {
        return false;
    }

    public void registerUser(String username, String password, String role) {
    }

    public boolean updatePassword(String username, String oldPassword, String newPassword) {
        return false;
    }

    public boolean deleteUser(String username) {
        return false;
    }

    public String getUserRole(String username) {
        return null;
    }

    public boolean isUserExists(String username) {
        return false;
    }
}