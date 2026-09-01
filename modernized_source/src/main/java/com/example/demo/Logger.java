package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public enum Level {
        INFO, WARN, ERROR, DEBUG
    }

    public void log(Level level, String message) {
        String formattedMessage = formatMessage(level, message);
        System.out.println(formattedMessage);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void warn(String message) {
        log(Level.WARN, message);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    private String formatMessage(Level level, String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);
        return String.format("[%s] [%s] %s", timestamp, level.name(), message);
    }
}