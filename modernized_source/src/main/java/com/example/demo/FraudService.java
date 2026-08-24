package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class FraudService {

    private static final double LARGE_DEPOSIT = 25000.0;
    private static final double LARGE_WITHDRAWAL = 10000.0;
    private static final int DAILY_TRANSACTION_LIMIT = 5;

    private final Map<String, Integer> transactionCount = new HashMap<>();

    /**
     * Checks if a deposit is potentially fraudulent.
     * 
     * @param account The account number.
     * @param amount  The deposit amount.
     * @return true if the deposit is allowed, false if it exceeds fraud thresholds.
     */
    public boolean checkDeposit(String account, double amount) {
        if (amount > LARGE_DEPOSIT) {
            System.out.println("[FRAUD ALERT] Large deposit detected for account: " + account + ", Amount: " + amount);
        }
        return incrementAndCheck(account);
    }

    /**
     * Checks if a withdrawal is potentially fraudulent.
     * 
     * @param account The account number.
     * @param amount  The withdrawal amount.
     * @return true if the withdrawal is allowed, false if it exceeds fraud thresholds.
     */
    public boolean checkWithdrawal(String account, double amount) {
        if (amount > LARGE_WITHDRAWAL) {
            System.out.println("[FRAUD ALERT] Large withdrawal detected for account: " + account + ", Amount: " + amount);
        }
        return incrementAndCheck(account);
    }

    /**
     * Increments the transaction count for the account and checks if it exceeds
     * the daily transaction limit.
     * 
     * @param account The account number.
     * @return true if the transaction count is within the limit, false otherwise.
     */
    private boolean incrementAndCheck(String account) {
        int count = transactionCount.getOrDefault(account, 0) + 1;
        transactionCount.put(account, count);

        if (count > DAILY_TRANSACTION_LIMIT) {
            System.out.println("[FRAUD ALERT] Daily transaction limit exceeded for account: " + account);
            return false;
        }
        return true;
    }
}