package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AuditService {

    private final List<String> logs = new ArrayList<>();

    /**
     * Records an audit log entry with a timestamp, action, and details.
     *
     * @param action  The action being recorded (e.g., "Deposit", "Withdrawal").
     * @param details Additional details about the action (e.g., "Account: 12345, Amount: 1000").
     */
    public void record(String action, String details) {
        if (action == null || action.isBlank() || details == null || details.isBlank()) {
            throw new IllegalArgumentException("Action and details must not be null or blank.");
        }
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String logEntry = String.format("[%s] ACTION: %s | DETAILS: %s", timestamp, action, details);
        logs.add(logEntry);
    }

    /**
     * Prints all audit log entries to the console.
     * If no logs are available, prints a message indicating that there are no entries.
     */
    public void printAll() {
        if (logs.isEmpty()) {
            System.out.println("No audit entries available.");
        } else {
            System.out.println("Audit Log Entries:");
            for (String log : logs) {
                System.out.println(log);
            }
        }
    }
}