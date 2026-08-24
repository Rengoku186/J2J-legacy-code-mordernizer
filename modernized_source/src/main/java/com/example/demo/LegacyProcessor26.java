package com.example.demo;

import java.util.List;
import java.util.ArrayList;

public class LegacyProcessor26 {

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
            return "P026-";
        }
        String upperValue = value.toUpperCase();
        String truncatedValue = upperValue.length() > 26 ? upperValue.substring(0, 26) : upperValue;
        return "P026-" + truncatedValue;
    }

    public int score(String value) {
        if (value == null) {
            return 0;
        }
        int score = 0;
        for (int i = 0; i < value.length(); i++) {
            score += value.charAt(i);
            if ((i + 1) % 5 == 0) {
                score += 26; // Bonus points for every 5th character
            }
        }
        return score;
    }
}