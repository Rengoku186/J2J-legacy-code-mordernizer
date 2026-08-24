package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    /**
     * Sends a notification with the specified message.
     * The notification includes a timestamp for when it was sent.
     *
     * @param message The message to be sent as a notification.
     */
    public void send(String message) {
        if (message == null || message.trim().isEmpty()) {
            System.out.println("[NOTIFICATION] No message to send.");
            return;
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[NOTIFICATION] [" + timestamp + "] " + message);
    }
}