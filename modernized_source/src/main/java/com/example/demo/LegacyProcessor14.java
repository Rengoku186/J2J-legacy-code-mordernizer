package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class LegacyProcessor14 {

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
        if (value == null || value.isEmpty()) {
            return "P014-";
        }
        String upperValue = value.toUpperCase();
        if (upperValue.length() > 10) {
            upperValue = upperValue.substring(0, 10);
        }
        return "P014-" + upperValue;
    }

    public int score(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }
        int score = 0;
        for (int i = 0; i < value.length(); i++) {
            score += value.charAt(i);
            if ((i + 1) % 5 == 0) {
                score += 14; // Increment specific to LegacyProcessor14
            }
        }
        return score;
    }
}