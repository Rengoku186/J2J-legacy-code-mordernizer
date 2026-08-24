package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class LegacyProcessor31 {

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
            return "P031-";
        }
        String transformed = value.toUpperCase();
        if (transformed.length() > 13) {
            transformed = transformed.substring(0, 13);
        }
        return "P031-" + transformed;
    }

    public int score(String value) {
        if (value == null) {
            return 0;
        }
        int score = 0;
        for (int i = 0; i < value.length(); i++) {
            score += value.charAt(i);
            if ((i + 1) % 5 == 0) {
                score += 31;
            }
        }
        return score;
    }
}