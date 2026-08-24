package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Service
public class CoreBankingSystemUpdater {

    // Simulated database to store account balances
    private final Map<String, Double> accountBalances = new ConcurrentHashMap<>();

    /**
     * Updates the core banking system with the specified account number and amount.
     * If the account does not exist, it initializes the account with the given amount.
     *
     * @param accountNumber The account number to update.
     * @param amount        The amount to add to the account balance.
     */
    public void updateCoreBankingSystem(String accountNumber, double amount) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        accountBalances.merge(accountNumber, amount, Double::sum);

        System.out.println("Core Banking System updated successfully.");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("New Balance: " + accountBalances.get(accountNumber));
    }

    /**
     * Retrieves the current balance for the specified account number.
     *
     * @param accountNumber The account number to retrieve the balance for.
     * @return The current balance of the account, or 0.0 if the account does not exist.
     */
    public double getAccountBalance(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty.");
        }

        return accountBalances.getOrDefault(accountNumber, 0.0);
    }

    /**
     * Displays all account balances in the core banking system.
     */
    public void displayAllAccountBalances() {
        if (accountBalances.isEmpty()) {
            System.out.println("No accounts found in the Core Banking System.");
            return;
        }

        System.out.println("=== Core Banking System Account Balances ===");
        accountBalances.forEach((accountNumber, balance) -> 
            System.out.println("Account Number: " + accountNumber + ", Balance: " + balance)
        );
    }
}