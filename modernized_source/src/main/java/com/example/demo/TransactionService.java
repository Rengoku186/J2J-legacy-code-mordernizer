package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {

    private Map<String, List<Transaction>> transactionMap = new HashMap<>();

    /**
     * Records a new transaction for the specified account.
     *
     * @param accountNumber The account number associated with the transaction.
     * @param type          The type of transaction (e.g., DEPOSIT, WITHDRAWAL).
     * @param amount        The amount of the transaction.
     * @param description   A description of the transaction.
     */
    public void record(String accountNumber, String type, double amount, String description) {
        // Create a new transaction
        Transaction transaction = new Transaction(accountNumber, type, amount, description);
        transaction.setTimestamp(LocalDateTime.now());

        // Retrieve the list of transactions for the account
        List<Transaction> transactions = transactionMap.getOrDefault(accountNumber, new ArrayList<>());

        // Add the new transaction to the list
        transactions.add(transaction);

        // Update the transaction map
        transactionMap.put(accountNumber, transactions);
    }

    /**
     * Retrieves all transactions for the specified account.
     *
     * @param accountNumber The account number for which transactions are to be retrieved.
     * @return A list of transactions for the specified account. Returns an empty list if no transactions exist.
     */
    public List<Transaction> getTransactions(String accountNumber) {
        return transactionMap.getOrDefault(accountNumber, new ArrayList<>());
    }

    /**
     * Retrieves all transactions across all accounts.
     *
     * @return A list of all transactions.
     */
    public List<Transaction> getAllTransactions() {
        List<Transaction> allTransactions = new ArrayList<>();
        for (List<Transaction> transactions : transactionMap.values()) {
            allTransactions.addAll(transactions);
        }
        return allTransactions;
    }
}