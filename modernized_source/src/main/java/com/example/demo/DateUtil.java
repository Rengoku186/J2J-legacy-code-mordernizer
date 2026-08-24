package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    /**
     * Returns the current date in the format "YYYY-MM-DD".
     *
     * @return A string representing today's date.
     */
    public static String today() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * Returns the current timestamp in ISO local date-time format.
     *
     * @return A string representing the current timestamp.
     */
    public static String timestamp() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}