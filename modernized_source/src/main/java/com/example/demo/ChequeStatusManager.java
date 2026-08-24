package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChequeStatusManager {

    private final Map<String, ChequeStatus> chequeStatusMap = new ConcurrentHashMap<>();

    /**
     * Sets the status of a cheque.
     *
     * @param accountNumber The account number associated with the cheque.
     * @param chequeNumber  The cheque number.
     * @param status        The new status of the cheque.
     */
    public void setStatus(String accountNumber, String chequeNumber, ChequeStatus status) {
        if (accountNumber == null || accountNumber.isEmpty() || chequeNumber == null || chequeNumber.isEmpty() || status == null) {
            throw new IllegalArgumentException("Account number, cheque number, and status must not be null or empty.");
        }
        String key = generateKey(accountNumber, chequeNumber);
        chequeStatusMap.put(key, status);
        System.out.println("Status of cheque " + chequeNumber + " for account " + accountNumber + " set to " + status);
    }

    /**
     * Retrieves the status of a cheque.
     *
     * @param accountNumber The account number associated with the cheque.
     * @param chequeNumber  The cheque number.
     * @return The status of the cheque, or null if the cheque is not found.
     */
    public ChequeStatus getStatus(String accountNumber, String chequeNumber) {
        if (accountNumber == null || accountNumber.isEmpty() || chequeNumber == null || chequeNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number and cheque number must not be null or empty.");
        }
        String key = generateKey(accountNumber, chequeNumber);
        return chequeStatusMap.get(key);
    }

    /**
     * Displays the statuses of all cheques.
     */
    public void displayAllStatuses() {
        if (chequeStatusMap.isEmpty()) {
            System.out.println("No cheque statuses available.");
        } else {
            System.out.println("--- All Cheque Statuses ---");
            chequeStatusMap.forEach((key, status) -> {
                String[] parts = key.split(":");
                String accountNumber = parts[0];
                String chequeNumber = parts[1];
                System.out.println("Account: " + accountNumber + ", Cheque: " + chequeNumber + ", Status: " + status);
            });
        }
    }

    /**
     * Generates a unique key for a cheque based on the account number and cheque number.
     *
     * @param accountNumber The account number associated with the cheque.
     * @param chequeNumber  The cheque number.
     * @return A unique key for the cheque.
     */
    private String generateKey(String accountNumber, String chequeNumber) {
        return accountNumber + ":" + chequeNumber;
    }
}

enum ChequeStatus {
    ISSUED,
    PROCESSED,
    CANCELED
}