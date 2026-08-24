package com.example.demo;

import java.util.List;
import java.util.ArrayList;

public class LegacyProcessor29 {

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
            return "P029-";
        }
        String upperValue = value.toUpperCase();
        if (upperValue.length() > 11) {
            upperValue = upperValue.substring(0, 11);
        }
        return "P029-" + upperValue;
    }

    public int score(String value) {
        if (value == null) {
            return 0;
        }
        int score = 0;
        for (int i = 0; i < value.length(); i++) {
            score += value.charAt(i);
            if ((i + 1) % 5 == 0) {
                score += 29; // Add class-specific increment for every 5th character
            }
        }
        return score;
    }
}