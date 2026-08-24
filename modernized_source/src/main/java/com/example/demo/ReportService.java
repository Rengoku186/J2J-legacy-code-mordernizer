package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportService {

    public void accountSummary(List<Account> accounts) {
        if (accounts == null || accounts.isEmpty()) {
            System.out.println("No accounts available to display.");
            return;
        }

        System.out.println("Account Summary:");
        System.out.printf("%-15s %-20s %-15s %-15s %-10s%n", "Account Number", "Customer Name", "Type", "Balance", "Status");
        double totalBalance = 0.0;

        for (Account account : accounts) {
            System.out.printf("%-15s %-20s %-15s %-15.2f %-10s%n",
                    account.getAccountNumber(),
                    account.getCustomerName(),
                    account.getType(),
                    account.getBalance(),
                    account.getStatus());
            totalBalance += account.getBalance();
        }

        System.out.printf("Total Balance Across All Accounts: %.2f%n", totalBalance);
    }

    public void transactionSummary(List<Transaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            System.out.println("No transactions available to display.");
            return;
        }

        System.out.println("Transaction Summary:");
        System.out.printf("%-20s %-15s %-15s %-15s %-30s%n", "Timestamp", "Account Number", "Type", "Amount", "Description");
        double totalDeposits = 0.0;
        double totalWithdrawals = 0.0;

        for (Transaction transaction : transactions) {
            System.out.printf("%-20s %-15s %-15s %-15.2f %-30s%n",
                    transaction.getTimestamp(),
                    transaction.getAccountNumber(),
                    transaction.getType(),
                    transaction.getAmount(),
                    transaction.getDescription());

            if ("DEPOSIT".equalsIgnoreCase(transaction.getType())) {
                totalDeposits += transaction.getAmount();
            } else if ("WITHDRAWAL".equalsIgnoreCase(transaction.getType())) {
                totalWithdrawals += transaction.getAmount();
            }
        }

        System.out.printf("Total Deposits: %.2f%n", totalDeposits);
        System.out.printf("Total Withdrawals: %.2f%n", totalWithdrawals);
        System.out.printf("Net Balance Change: %.2f%n", totalDeposits - totalWithdrawals);
    }

    public void loanSummary(List<Loan> loans) {
        if (loans == null || loans.isEmpty()) {
            System.out.println("No loans available to display.");
            return;
        }

        System.out.println("Loan Summary:");
        System.out.printf("%-10s %-15s %-15s %-15s %-15s %-10s%n", "Loan ID", "Customer ID", "Principal", "Interest Rate", "Outstanding", "Status");
        double totalOutstanding = 0.0;

        for (Loan loan : loans) {
            System.out.printf("%-10s %-15s %-15.2f %-15.2f %-15.2f %-10s%n",
                    loan.getLoanId(),
                    loan.getCustomerId(),
                    loan.getPrincipal(),
                    loan.getInterestRate(),
                    loan.getOutstanding(),
                    loan.getStatus());
            totalOutstanding += loan.getOutstanding();
        }

        System.out.printf("Total Outstanding Loan Amount: %.2f%n", totalOutstanding);
    }
}