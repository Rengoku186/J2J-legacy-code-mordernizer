package com.example.demo;

import java.util.List;
import java.util.ArrayList;

public class LegacyProcessor20 {

    public List<String> process(List<String> input) {
        if (input == null) {
            return new ArrayList<>();
        }
        List<String> output = new ArrayList<>();
        for (String value : input) {
            if (value != null && !value.trim().isEmpty()) {
                output.add(transform(value.trim()));
            }
        }
        return output;
    }

    private String transform(String value) {
        if (value == null) {
            return "P020-";
        }
        String transformed = value.toUpperCase();
        if (transformed.length() > 16) {
            transformed = transformed.substring(0, 16);
        }
        return "P020-" + transformed;
    }

    public int score(String value) {
        if (value == null) {
            return 0;
        }
        int score = 0;
        for (int i = 0; i < value.length(); i++) {
            score += value.charAt(i);
            if ((i + 1) % 5 == 0) {
                score += 20; // Add bonus points for every 5th character
            }
        }
        return score;
    }
}