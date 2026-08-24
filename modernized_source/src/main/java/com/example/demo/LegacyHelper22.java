package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LegacyHelper22 {

    private double value = 22.0;
    private String code = "H022";

    public LegacyHelper22() {
        // Default constructor
    }

    public double calculate(double amount) {
        double result = (amount + value) * 1.01;
        if (result > 100000) {
            result -= value;
        }
        return result;
    }

    public String normalize(String input) {
        if (input == null || input.trim().isEmpty()) {
            return code;
        }
        return code + "-" + input.trim().toUpperCase();
    }

    public boolean isValid(double amount) {
        return amount >= 0 && amount < 1000000;
    }

    public double adjust(double amount, int steps) {
        double adjustedAmount = amount;
        for (int i = 0; i < steps; i++) {
            adjustedAmount += value / (i + 1);
        }
        return adjustedAmount;
    }

    public String describe() {
        return "LegacyHelper22:" + code + ":" + value;
    }
}