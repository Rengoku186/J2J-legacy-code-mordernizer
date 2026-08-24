package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LegacyHelper19 {

    private final double value = 19.0;
    private final String code = "H019";

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
        return "LegacyHelper19:" + code + ":" + value;
    }
}