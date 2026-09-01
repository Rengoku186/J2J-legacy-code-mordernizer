package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CoreBankingSystemUpdater {

    // Simulated database for account balances
    private final Map<String, Double> accountBalances = new HashMap<>();

    /**
     * Updates the core banking system with the transaction details.
     * Adds the transaction amount to the account's balance.
     *
     * @param accountNumber The account number to update.
     * @param amount        The amount to add to the account balance.
     */
    public void updateCoreBankingSystem(String accountNumber, double amount) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be null or blank.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Transaction amount must be greater than zero.");
        }

        synchronized (this) {
            double currentBalance = accountBalances.getOrDefault(accountNumber, 0.0);
            double updatedBalance = currentBalance + amount;
            accountBalances.put(accountNumber, updatedBalance);

            Logger logger = new Logger();
            logger.info("Updated account balance for account " + accountNumber + ": " + updatedBalance);
        }
    }

    /**
     * Retrieves the current balance of the specified account.
     *
     * @param accountNumber The account number to query.
     * @return The current balance of the account.
     */
    public double getAccountBalance(String accountNumber) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be null or blank.");
        }

        synchronized (this) {
            return accountBalances.getOrDefault(accountNumber, 0.0);
        }
    }

    /**
     * Resets the balance of the specified account to zero.
     *
     * @param accountNumber The account number to reset.
     */
    public void resetAccountBalance(String accountNumber) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be null or blank.");
        }

        synchronized (this) {
            accountBalances.put(accountNumber, 0.0);

            Logger logger = new Logger();
            logger.info("Reset account balance for account " + accountNumber + " to zero.");
        }
    }

    /**
     * Displays all account balances in the system.
     */
    public void displayAllAccountBalances() {
        synchronized (this) {
            if (accountBalances.isEmpty()) {
                Logger logger = new Logger();
                logger.info("No accounts found in the system.");
                return;
            }

            Logger logger = new Logger();
            logger.info("Displaying all account balances:");
            accountBalances.forEach((accountNumber, balance) -> 
                logger.info("Account: " + accountNumber + ", Balance: " + balance)
            );
        }
    }
}