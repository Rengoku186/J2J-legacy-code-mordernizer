package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class LegacyProcessor9 {

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
            return "P009-";
        }
        String upperValue = value.toUpperCase();
        if (upperValue.length() > 12) {
            upperValue = upperValue.substring(0, 12);
        }
        return "P009-" + upperValue;
    }

    public int score(String value) {
        if (value == null) {
            return 0;
        }
        int score = 0;
        for (int i = 0; i < value.length(); i++) {
            score += value.charAt(i);
            if ((i + 1) % 5 == 0) {
                score += 9; // Add 9 for every 5th character
            }
        }
        return score;
    }
}