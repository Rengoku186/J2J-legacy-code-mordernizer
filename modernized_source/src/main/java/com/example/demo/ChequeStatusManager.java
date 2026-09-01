package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ChequeStatusManager {

    private final Map<String, ChequeStatus> chequeStatusMap = new HashMap<>();

    /**
     * Sets the status of a cheque.
     *
     * @param accountNumber The account number associated with the cheque.
     * @param chequeNumber  The cheque number.
     * @param status        The new status of the cheque.
     */
    public void setStatus(String accountNumber, String chequeNumber, ChequeStatus status) {
        if (accountNumber == null || accountNumber.isEmpty() || chequeNumber == null || chequeNumber.isEmpty()) {
            log.error("Account number or cheque number cannot be null or empty.");
            throw new IllegalArgumentException("Account number and cheque number must be provided.");
        }
        String key = generateKey(accountNumber, chequeNumber);
        chequeStatusMap.put(key, status);
        log.info("Status of cheque {} for account {} set to {}", chequeNumber, accountNumber, status);
    }

    /**
     * Retrieves the status of a cheque.
     *
     * @param accountNumber The account number associated with the cheque.
     * @param chequeNumber  The cheque number.
     * @return The status of the cheque, or null if no status is found.
     */
    public ChequeStatus getStatus(String accountNumber, String chequeNumber) {
        if (accountNumber == null || accountNumber.isEmpty() || chequeNumber == null || chequeNumber.isEmpty()) {
            log.error("Account number or cheque number cannot be null or empty.");
            throw new IllegalArgumentException("Account number and cheque number must be provided.");
        }
        String key = generateKey(accountNumber, chequeNumber);
        ChequeStatus status = chequeStatusMap.get(key);
        if (status == null) {
            log.warn("No status found for cheque {} of account {}", chequeNumber, accountNumber);
        }
        return status;
    }

    /**
     * Displays the status of all cheques.
     */
    public void displayAllStatuses() {
        if (chequeStatusMap.isEmpty()) {
            log.info("No cheque statuses recorded.");
            System.out.println("No cheque statuses recorded.");
            return;
        }
        System.out.println("All Cheque Statuses:");
        chequeStatusMap.forEach((key, status) -> {
            String[] parts = key.split(":");
            String accountNumber = parts[0];
            String chequeNumber = parts[1];
            System.out.printf("Account: %s, Cheque: %s, Status: %s%n", accountNumber, chequeNumber, status);
        });
    }

    /**
     * Generates a unique key for a cheque based on the account number and cheque number.
     *
     * @param accountNumber The account number.
     * @param chequeNumber  The cheque number.
     * @return A unique key in the format "accountNumber:chequeNumber".
     */
    private String generateKey(String accountNumber, String chequeNumber) {
        return accountNumber + ":" + chequeNumber;
    }

    /**
     * Enum representing the possible statuses of a cheque.
     */
    public enum ChequeStatus {
        ISSUED,
        PROCESSED,
        CANCELED
    }
}