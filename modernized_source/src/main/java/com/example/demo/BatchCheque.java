package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The BatchCheque class represents a cheque in the system.
 * It contains details such as the account number, cheque number, currency, amount, and signature.
 */
@Data
@AllArgsConstructor
public class BatchCheque {
    private String accountNumber;
    private String chequeNumber;
    private String currency;
    private double amount;
    private String signature;

    /**
     * Validates the cheque details to ensure they meet the required criteria.
     * 
     * @return true if the cheque details are valid, false otherwise.
     */
    public boolean validateChequeDetails() {
        if (accountNumber == null || accountNumber.isEmpty()) {
            return false;
        }
        if (chequeNumber == null || chequeNumber.isEmpty()) {
            return false;
        }
        if (currency == null || currency.isEmpty()) {
            return false;
        }
        if (amount <= 0) {
            return false;
        }
        if (signature == null || signature.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Formats the cheque details into a readable string.
     * 
     * @return A string representation of the cheque details.
     */
    @Override
    public String toString() {
        return String.format(
            "BatchCheque [Account Number: %s, Cheque Number: %s, Currency: %s, Amount: %.2f, Signature: %s]",
            accountNumber, chequeNumber, currency, amount, signature
        );
    }
}