package com.example.demo;

import java.util.List;
import java.util.ArrayList;

public class LegacyProcessor33 {

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
            return "P033-";
        }
        String upperValue = value.toUpperCase();
        String truncatedValue = upperValue.length() > 15 ? upperValue.substring(0, 15) : upperValue;
        return "P033-" + truncatedValue;
    }

    public int score(String value) {
        if (value == null) {
            return 0;
        }
        int score = 0;
        for (int i = 0; i < value.length(); i++) {
            score += value.charAt(i);
            if ((i + 1) % 5 == 0) {
                score += 33;
            }
        }
        return score;
    }
}