package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class EmailNotificationService {

    // Regex pattern for validating email addresses
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
    );

    /**
     * Sends an email to a single recipient.
     *
     * @param recipient The email address of the recipient.
     * @param subject   The subject of the email.
     * @param body      The body of the email.
     */
    public void sendEmail(String recipient, String subject, String body) {
        if (!validateEmailAddress(recipient)) {
            System.err.println("Invalid email address: " + recipient);
            return;
        }

        // Simulate sending an email
        System.out.println("Sending email to: " + recipient);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        System.out.println("Email sent successfully.");
    }

    /**
     * Sends an email to multiple recipients.
     *
     * @param recipients An array of email addresses of the recipients.
     * @param subject    The subject of the email.
     * @param body       The body of the email.
     */
    public void sendBulkEmails(String[] recipients, String subject, String body) {
        if (recipients == null || recipients.length == 0) {
            System.err.println("No recipients provided for bulk email.");
            return;
        }

        for (String recipient : recipients) {
            if (!validateEmailAddress(recipient)) {
                System.err.println("Invalid email address in bulk email: " + recipient);
                continue;
            }

            // Simulate sending an email
            System.out.println("Sending email to: " + recipient);
            System.out.println("Subject: " + subject);
            System.out.println("Body: " + body);
        }

        System.out.println("Bulk email process completed.");
    }

    /**
     * Validates an email address using a regex pattern.
     *
     * @param email The email address to validate.
     * @return True if the email address is valid, false otherwise.
     */
    public boolean validateEmailAddress(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }
}