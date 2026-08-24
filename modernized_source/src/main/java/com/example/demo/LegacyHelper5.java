package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LegacyHelper5 {

    private final double value = 5.0;
    private final String code = "H005";

    /**
     * Performs a calculation by adding the value to the input amount, applying a 1% increase,
     * and conditionally subtracting the value if the result exceeds 100,000.
     *
     * @param amount The input amount to be calculated.
     * @return The calculated result.
     */
    public double calculate(double amount) {
        double result = (amount + value) * 1.01;
        if (result > 100000) {
            result -= value;
        }
        return result;
    }

    /**
     * Normalizes a string input by trimming whitespace, converting it to uppercase,
     * and appending it to the code. If the input is null or empty, returns the code alone.
     *
     * @param input The string to be normalized.
     * @return The normalized result.
     */
    public String normalize(String input) {
        if (input == null || input.trim().isEmpty()) {
            return code;
        }
        return code + "-" + input.trim().toUpperCase();
    }

    /**
     * Validates whether the input amount is within the range [0, 1,000,000).
     *
     * @param amount The amount to be validated.
     * @return True if the amount is valid, false otherwise.
     */
    public boolean isValid(double amount) {
        return amount >= 0 && amount < 1000000;
    }

    /**
     * Adjusts the input amount by incrementally adding fractions of the value over a specified number of steps.
     *
     * @param amount The initial amount to be adjusted.
     * @param steps  The number of adjustment steps.
     * @return The adjusted amount.
     */
    public double adjust(double amount, int steps) {
        double adjustedAmount = amount;
        for (int i = 0; i < steps; i++) {
            adjustedAmount += value / (i + 1);
        }
        return adjustedAmount;
    }

    /**
     * Provides a string description of the class, including its code and value.
     *
     * @return A string describing the class.
     */
    public String describe() {
        return "LegacyHelper5:" + code + ":" + value;
    }
}