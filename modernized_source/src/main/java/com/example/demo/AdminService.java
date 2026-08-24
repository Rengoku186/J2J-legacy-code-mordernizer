package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    public boolean createAccount(String number, String name, String type, AccountService accountService) {
        if (number == null || name == null || type == null || number.isEmpty() || name.isEmpty() || type.isEmpty()) {
            System.out.println("[ERROR] Invalid account details provided.");
            return false;
        }

        Account newAccount = new Account(number, name, type);
        boolean isAdded = accountService.addAccount(newAccount);

        if (isAdded) {
            System.out.println("[SUCCESS] Account created successfully: " + number);
            return true;
        } else {
            System.out.println("[ERROR] Account creation failed. Account number might already exist: " + number);
            return false;
        }
    }

    public void blockAccount(String accountNumber, AccountService accountService) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            System.out.println("[ERROR] Invalid account number provided.");
            return;
        }

        boolean isBlocked = accountService.block(accountNumber);

        if (isBlocked) {
            System.out.println("[SUCCESS] Account blocked successfully: " + accountNumber);
        } else {
            System.out.println("[ERROR] Failed to block account. Account might not exist or is already blocked: " + accountNumber);
        }
    }

    public void unblockAccount(String accountNumber, AccountService accountService) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            System.out.println("[ERROR] Invalid account number provided.");
            return;
        }

        boolean isUnblocked = accountService.unblock(accountNumber);

        if (isUnblocked) {
            System.out.println("[SUCCESS] Account unblocked successfully: " + accountNumber);
        } else {
            System.out.println("[ERROR] Failed to unblock account. Account might not exist or is already active: " + accountNumber);
        }
    }
}