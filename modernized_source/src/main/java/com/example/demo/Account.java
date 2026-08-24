package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

    private String accountNumber;
    private String customerName;
    private String type;
    private double balance;
    private String status;

    public Account(String accountNumber, String customerName, String type) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.type = type;
        this.balance = 1000.0; // Default balance
        this.status = "ACTIVE"; // Default status
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
    }

    public boolean withdraw(double amount) {
        if ("BLOCKED".equalsIgnoreCase(this.status)) {
            System.out.println("Account is blocked. Withdrawal not allowed.");
            return false;
        }
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
            return false;
        }
    }

    public void block() {
        this.status = "BLOCKED";
    }

    public void unblock() {
        this.status = "ACTIVE";
    }
}