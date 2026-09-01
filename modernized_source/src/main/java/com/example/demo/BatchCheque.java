package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * Represents a cheque in a batch with details such as account number, cheque number, currency, amount, and signature.
 */
@Data
@NoArgsConstructor
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
        if (accountNumber == null || accountNumber.isBlank()) {
            return false;
        }
        if (chequeNumber == null || chequeNumber.isBlank()) {
            return false;
        }
        if (currency == null || currency.isBlank()) {
            return false;
        }
        if (amount <= 0) {
            return false;
        }
        if (signature == null || signature.isBlank()) {
            return false;
        }
        return true;
    }

    /**
     * Checks if this cheque is equal to another cheque based on account number and cheque number.
     *
     * @param otherCheque The other cheque to compare with.
     * @return true if the account number and cheque number match, false otherwise.
     */
    public boolean isDuplicate(BatchCheque otherCheque) {
        if (otherCheque == null) {
            return false;
        }
        return Objects.equals(this.accountNumber, otherCheque.accountNumber) &&
               Objects.equals(this.chequeNumber, otherCheque.chequeNumber);
    }

    /**
     * Formats the cheque details into a readable string representation.
     *
     * @return A string representation of the cheque details.
     */
    @Override
    public String toString() {
        return "BatchCheque{" +
                "accountNumber='" + accountNumber + '\'' +
                ", chequeNumber='" + chequeNumber + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", signature='" + signature + '\'' +
                '}';
    }
}