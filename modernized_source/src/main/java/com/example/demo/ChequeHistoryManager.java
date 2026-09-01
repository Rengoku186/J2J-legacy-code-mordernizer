package com.example.demo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Interface for managing cheque history.
 */
public interface ChequeHistoryManager {

    void recordCheque(String accountNumber, String chequeNumber, String currency, double amount, Date date);

    List<ChequeRecord> getChequeHistory(String accountNumber);

    boolean isChequeDuplicate(String accountNumber, String chequeNumber);

    double getAverageMonthlyFrequency(String accountNumber);

    List<ChequeRecord> getRecentTransactions(String accountNumber, int days);

    /**
     * Represents a record of a cheque transaction.
     */
    class ChequeRecord {
        private final String accountNumber;
        private final String chequeNumber;
        private final String currency;
        private final double amount;
        private final Date date;

        public ChequeRecord(String accountNumber, String chequeNumber, String currency, double amount, Date date) {
            this.accountNumber = accountNumber;
            this.chequeNumber = chequeNumber;
            this.currency = currency;
            this.amount = amount;
            this.date = date;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getChequeNumber() {
            return chequeNumber;
        }

        public String getCurrency() {
            return currency;
        }

        public double getAmount() {
            return amount;
        }

        public Date getDate() {
            return date;
        }
    }
}