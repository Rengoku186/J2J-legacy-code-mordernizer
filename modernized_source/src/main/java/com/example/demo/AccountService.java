package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Getter
@Setter
public class AccountService {

    private Map<String, Account> accounts = new ConcurrentHashMap<>();

    public void initializeDefaultAccounts() {
        // Adding some default accounts for testing purposes
        Account account1 = new Account("ACC001", "John Doe", "SAVINGS");
        Account account2 = new Account("ACC002", "Jane Smith", "CURRENT");
        Account account3 = new Account("ACC003", "Alice Johnson", "SAVINGS");

        accounts.put(account1.getAccountNumber(), account1);
        accounts.put(account2.getAccountNumber(), account2);
        accounts.put(account3.getAccountNumber(), account3);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }

    public boolean addAccount(Account account) {
        if (accounts.containsKey(account.getAccountNumber())) {
            return false; // Account with the same number already exists
        }
        accounts.put(account.getAccountNumber(), account);
        return true;
    }

    public boolean deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null && amount > 0) {
            account.setBalance(account.getBalance() + amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null && amount > 0 && account.getBalance() >= amount && "ACTIVE".equals(account.getStatus())) {
            account.setBalance(account.getBalance() - amount);
            return true;
        }
        return false;
    }

    public boolean block(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null && !"BLOCKED".equals(account.getStatus())) {
            account.setStatus("BLOCKED");
            return true;
        }
        return false;
    }

    public boolean unblock(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null && "BLOCKED".equals(account.getStatus())) {
            account.setStatus("ACTIVE");
            return true;
        }
        return false;
    }
}