package com.example.demo;

import java.util.List;
import java.util.ArrayList;

public class LegacyProcessor25 {

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
            return "P025-";
        }
        String upperValue = value.toUpperCase();
        if (upperValue.length() > 14) {
            upperValue = upperValue.substring(0, 14);
        }
        return "P025-" + upperValue;
    }

    public int score(String value) {
        if (value == null) {
            return 0;
        }
        int score = 0;
        for (int i = 0; i < value.length(); i++) {
            score += value.charAt(i);
            if ((i + 1) % 5 == 0) {
                score += 25;
            }
        }
        return score;
    }
}