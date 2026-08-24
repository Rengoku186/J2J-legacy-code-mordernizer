---
original_file: "legacy_source/LegacyBankingApplication.java"
language: "Java"
chunk_id: "chunk_15"
confidence_score: 0.95
external_dependencies: ["java.util.List", "java.util.ArrayList", "java.time.LocalDate", "java.time.LocalDateTime", "java.time.format.DateTimeFormatter"]
---

# Documentation for `LegacyProcessor31`, `LegacyProcessor32`, `LegacyProcessor33`, `LegacyProcessor34`, `LegacyProcessor35`, and Utility Classes

This document provides an overview of the classes `LegacyProcessor31`, `LegacyProcessor32`, `LegacyProcessor33`, `LegacyProcessor34`, and `LegacyProcessor35`, as well as the utility classes `BankingMathUtil`, `StringUtil`, and `DateUtil`.

## Overview
The `LegacyProcessor` classes (`LegacyProcessor31` through `LegacyProcessor35`) are designed to process a list of strings, transform each string based on specific rules, and calculate a score for a given string. Each processor class follows a similar structure but applies slightly different transformation rules.

The utility classes (`BankingMathUtil`, `StringUtil`, and `DateUtil`) provide helper methods for mathematical operations, string manipulations, and date/time operations, respectively.

---

## Class: `LegacyProcessor31`

### Methods

#### `List<String> process(List<String> input)`
Processes a list of strings by trimming whitespace, filtering out null or empty strings, and applying a transformation to each valid string.

- **Parameters:**
  - `input` (List<String>): A list of strings to process.
- **Returns:**
  - A list of transformed strings.

#### `private String transform(String value)`
Transforms a string by converting it to uppercase, truncating it to a maximum of 13 characters, and prefixing it with `"P031-"`.

- **Parameters:**
  - `value` (String): The string to transform.
- **Returns:**
  - The transformed string.

#### `public int score(String value)`
Calculates a score for a given string based on the sum of its character values, with an additional increment of 31 for every 5th character.

- **Parameters:**
  - `value` (String): The string to score.
- **Returns:**
  - The calculated score as an integer.

---

## Class: `LegacyProcessor32`

### Methods

#### `List<String> process(List<String> input)`
Similar to `LegacyProcessor31.process`, but applies a different transformation rule.

#### `private String transform(String value)`
Transforms a string by converting it to uppercase, truncating it to a maximum of 14 characters, and prefixing it with `"P032-"`.

#### `public int score(String value)`
Calculates a score for a given string, adding 32 for every 5th character.

---

## Class: `LegacyProcessor33`

### Methods

#### `List<String> process(List<String> input)`
Similar to `LegacyProcessor31.process`, but applies a different transformation rule.

#### `private String transform(String value)`
Transforms a string by converting it to uppercase, truncating it to a maximum of 15 characters, and prefixing it with `"P033-"`.

#### `public int score(String value)`
Calculates a score for a given string, adding 33 for every 5th character.

---

## Class: `LegacyProcessor34`

### Methods

#### `List<String> process(List<String> input)`
Similar to `LegacyProcessor31.process`, but applies a different transformation rule.

#### `private String transform(String value)`
Transforms a string by converting it to uppercase, truncating it to a maximum of 16 characters, and prefixing it with `"P034-"`.

#### `public int score(String value)`
Calculates a score for a given string, adding 34 for every 5th character.

---

## Class: `LegacyProcessor35`

### Methods

#### `List<String> process(List<String> input)`
Similar to `LegacyProcessor31.process`, but applies a different transformation rule.

#### `private String transform(String value)`
Transforms a string by converting it to uppercase, truncating it to a maximum of 10 characters, and prefixing it with `"P035-"`.

#### `public int score(String value)`
Calculates a score for a given string, adding 35 for every 5th character.

---

## Utility Classes

### Class: `BankingMathUtil`

Provides utility methods for basic mathematical operations.

#### Methods

- `public static double round(double value)`: Rounds a double value to two decimal places.
- `public static double percentage(double value, double rate)`: Calculates the percentage of a value given a rate.
- `public static double add(double a, double b)`: Adds two double values.
- `public static double subtract(double a, double b)`: Subtracts the second double value from the first.
- `public static double multiply(double a, double b)`: Multiplies two double values.
- `public static double divide(double a, double b)`: Divides the first double value by the second. Returns 0 if the divisor is 0.

### Class: `StringUtil`

Provides utility methods for string manipulations.

#### Methods

- `public static String safe(String value)`: Returns a trimmed string or an empty string if the input is null.
- `public static boolean isBlank(String value)`: Checks if a string is null or empty after trimming.
- `public static String upper(String value)`: Converts a string to uppercase after trimming.
- `public static String lower(String value)`: Converts a string to lowercase after trimming.

### Class: `DateUtil`

Provides utility methods for date and time operations.

#### Methods

- `public static String today()`: Returns the current date in `YYYY-MM-DD` format.
- `public static String timestamp()`: Returns the current timestamp in ISO local date-time format.

---

## Notes
- The `LegacyProcessor` classes share a common structure but differ in their transformation rules and scoring logic.
- The utility classes are designed to provide common functionality and are independent of the `LegacyProcessor` classes.
- The code is compatible with Java 8 and relies only on the standard library.