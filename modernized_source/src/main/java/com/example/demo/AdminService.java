package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class AdminService {

    private Map<String, String> ifscToBankCode = new HashMap<>();
    private Map<String, String> bankCodeToName = new HashMap<>();
    private Map<String, List<BatchCheque>> batches = new HashMap<>();
    private Set<String> stuckTransactions = new HashSet<>();

    public void addOrUpdateIFSC(String ifsc, String bankCode) {
        ifscToBankCode.put(ifsc, bankCode);
        System.out.println("IFSC code " + ifsc + " has been added/updated with bank code " + bankCode + ".");
    }

    public void addOrUpdateBankCode(String bankCode, String bankName) {
        bankCodeToName.put(bankCode, bankName);
        System.out.println("Bank code " + bankCode + " has been added/updated with bank name " + bankName + ".");
    }

    public void displayIFSCs() {
        if (ifscToBankCode.isEmpty()) {
            System.out.println("No IFSC codes available.");
        } else {
            System.out.println("IFSC to Bank Code Mappings:");
            ifscToBankCode.forEach((ifsc, bankCode) -> 
                System.out.println("IFSC: " + ifsc + " -> Bank Code: " + bankCode));
        }
    }

    public void displayBankCodes() {
        if (bankCodeToName.isEmpty()) {
            System.out.println("No Bank codes available.");
        } else {
            System.out.println("Bank Code to Bank Name Mappings:");
            bankCodeToName.forEach((bankCode, bankName) -> 
                System.out.println("Bank Code: " + bankCode + " -> Bank Name: " + bankName));
        }
    }

    public void createBatch(String batchId, List<BatchCheque> cheques) {
        if (batches.containsKey(batchId)) {
            System.out.println("Batch ID " + batchId + " already exists. Please use a unique batch ID.");
            return;
        }
        batches.put(batchId, cheques);
        System.out.println("Batch " + batchId + " created with " + cheques.size() + " cheques.");
    }

    public void displayBatches() {
        if (batches.isEmpty()) {
            System.out.println("No batches available.");
        } else {
            System.out.println("Available Batches:");
            batches.forEach((batchId, cheques) -> 
                System.out.println("Batch ID: " + batchId + " -> Number of Cheques: " + cheques.size()));
        }
    }

    public void displayBatchDetails(String batchId) {
        List<BatchCheque> cheques = batches.get(batchId);
        if (cheques == null) {
            System.out.println("Batch ID " + batchId + " not found.");
            return;
        }
        System.out.println("Details for Batch ID: " + batchId);
        for (BatchCheque cheque : cheques) {
            System.out.println("Account Number: " + cheque.getAccountNumber() +
                               ", Cheque Number: " + cheque.getChequeNumber() +
                               ", Currency: " + cheque.getCurrency() +
                               ", Amount: " + cheque.getAmount() +
                               ", Signature: " + cheque.getSignature());
        }
    }

    public void markTransactionStuck(String chequeNumber) {
        if (stuckTransactions.contains(chequeNumber)) {
            System.out.println("Cheque number " + chequeNumber + " is already marked as stuck.");
            return;
        }
        stuckTransactions.add(chequeNumber);
        System.out.println("Cheque number " + chequeNumber + " has been marked as stuck.");
    }

    public void resetStuckTransaction(String chequeNumber) {
        if (stuckTransactions.remove(chequeNumber)) {
            System.out.println("Cheque number " + chequeNumber + " has been removed from stuck transactions.");
        } else {
            System.out.println("Cheque number " + chequeNumber + " was not marked as stuck.");
        }
    }

    public void displayStuckTransactions() {
        if (stuckTransactions.isEmpty()) {
            System.out.println("No stuck transactions available.");
        } else {
            System.out.println("Stuck Transactions:");
            stuckTransactions.forEach(chequeNumber -> 
                System.out.println("Cheque Number: " + chequeNumber));
        }
    }
}