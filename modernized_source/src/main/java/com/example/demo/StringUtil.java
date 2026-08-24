package com.example.demo;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtil {

    /**
     * Returns a trimmed string or an empty string if the input is null.
     *
     * @param value the input string
     * @return the trimmed string or an empty string if null
     */
    public String safe(String value) {
        return value == null ? "" : value.trim();
    }

    /**
     * Checks if a string is null or empty after trimming.
     *
     * @param value the input string
     * @return true if the string is null or empty, false otherwise
     */
    public boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Converts a string to uppercase after trimming.
     *
     * @param value the input string
     * @return the uppercase string or an empty string if null
     */
    public String upper(String value) {
        return safe(value).toUpperCase();
    }

    /**
     * Converts a string to lowercase after trimming.
     *
     * @param value the input string
     * @return the lowercase string or an empty string if null
     */
    public String lower(String value) {
        return safe(value).toLowerCase();
    }
}