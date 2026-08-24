package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    /**
     * Sends a generic email to the specified recipient.
     *
     * @param recipient The email address of the recipient.
     * @param subject   The subject of the email.
     * @param body      The body content of the email.
     */
    public void sendEmail(String recipient, String subject, String body) {
        // Simulate sending an email
        System.out.println("Sending email to: " + recipient);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        System.out.println("Email sent successfully.");
    }

    /**
     * Sends an error notification email to the specified recipient.
     *
     * @param recipient   The email address of the recipient.
     * @param errorDetails The details of the error to include in the email.
     */
    public void sendErrorNotification(String recipient, String errorDetails) {
        String subject = "Error Notification";
        String body = "Dear User,\n\nAn error occurred in the system:\n\n" + errorDetails + "\n\nPlease address this issue promptly.\n\nBest regards,\nSystem Administrator";
        sendEmail(recipient, subject, body);
    }

    /**
     * Sends a fraud alert email to the specified recipient.
     *
     * @param recipient   The email address of the recipient.
     * @param alertDetails The details of the fraud alert to include in the email.
     */
    public void sendFraudAlert(String recipient, String alertDetails) {
        String subject = "Fraud Alert Notification";
        String body = "Dear User,\n\nA potential fraud has been detected:\n\n" + alertDetails + "\n\nPlease review this matter immediately.\n\nBest regards,\nFraud Detection Team";
        sendEmail(recipient, subject, body);
    }
}