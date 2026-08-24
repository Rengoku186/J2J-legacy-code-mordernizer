package com.example.demo;

public class BankingMathUtil {

    /**
     * Rounds a double value to two decimal places.
     *
     * @param value the value to round
     * @return the rounded value
     */
    public static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    /**
     * Calculates the percentage of a value given a rate.
     *
     * @param value the base value
     * @param rate  the percentage rate
     * @return the calculated percentage
     */
    public static double percentage(double value, double rate) {
        return round(value * rate / 100.0);
    }

    /**
     * Adds two double values.
     *
     * @param a the first value
     * @param b the second value
     * @return the sum of the values
     */
    public static double add(double a, double b) {
        return round(a + b);
    }

    /**
     * Subtracts the second double value from the first.
     *
     * @param a the first value
     * @param b the second value
     * @return the result of the subtraction
     */
    public static double subtract(double a, double b) {
        return round(a - b);
    }

    /**
     * Multiplies two double values.
     *
     * @param a the first value
     * @param b the second value
     * @return the product of the values
     */
    public static double multiply(double a, double b) {
        return round(a * b);
    }

    /**
     * Divides the first double value by the second. Returns 0 if the divisor is 0.
     *
     * @param a the dividend
     * @param b the divisor
     * @return the result of the division, or 0 if the divisor is 0
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            return 0.0;
        }
        return round(a / b);
    }
}