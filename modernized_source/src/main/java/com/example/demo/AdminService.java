package com.example.demo;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final Map<String, String> ifscToBankCodeMap = new HashMap<>();
    private final Map<String, String> bankCodeToNameMap = new HashMap<>();
    private final Map<String, List<BatchCheque>> batchMap = new HashMap<>();
    private final Set<String> stuckTransactions = new HashSet<>();

    public void addOrUpdateIFSC(String ifsc, String bankCode) {
        if (ifsc == null || bankCode == null || ifsc.isEmpty() || bankCode.isEmpty()) {
            System.out.println("Invalid IFSC or Bank Code. Please provide valid inputs.");
            return;
        }
        ifscToBankCodeMap.put(ifsc, bankCode);
        System.out.println("IFSC " + ifsc + " has been added/updated with Bank Code: " + bankCode);
    }

    public void addOrUpdateBankCode(String code, String name) {
        if (code == null || name == null || code.isEmpty() || name.isEmpty()) {
            System.out.println("Invalid Bank Code or Bank Name. Please provide valid inputs.");
            return;
        }
        bankCodeToNameMap.put(code, name);
        System.out.println("Bank Code " + code + " has been added/updated with Bank Name: " + name);
    }

    public void displayIFSCs() {
        if (ifscToBankCodeMap.isEmpty()) {
            System.out.println("No IFSC codes available.");
            return;
        }
        System.out.println("List of IFSC codes and their corresponding Bank Codes:");
        ifscToBankCodeMap.forEach((ifsc, bankCode) -> 
            System.out.println("IFSC: " + ifsc + " -> Bank Code: " + bankCode)
        );
    }

    public void displayBankCodes() {
        if (bankCodeToNameMap.isEmpty()) {
            System.out.println("No Bank Codes available.");
            return;
        }
        System.out.println("List of Bank Codes and their corresponding Bank Names:");
        bankCodeToNameMap.forEach((code, name) -> 
            System.out.println("Bank Code: " + code + " -> Bank Name: " + name)
        );
    }

    public void createBatch(String batchId, List<BatchCheque> batchCheques) {
        if (batchId == null || batchId.isEmpty() || batchCheques == null || batchCheques.isEmpty()) {
            System.out.println("Invalid Batch ID or Batch Cheques. Please provide valid inputs.");
            return;
        }
        batchMap.put(batchId, new ArrayList<>(batchCheques));
        System.out.println("Batch " + batchId + " has been created with " + batchCheques.size() + " cheques.");
    }

    public void displayBatches() {
        if (batchMap.isEmpty()) {
            System.out.println("No batches available.");
            return;
        }
        System.out.println("List of all batches:");
        batchMap.forEach((batchId, cheques) -> 
            System.out.println("Batch ID: " + batchId + " -> Number of Cheques: " + cheques.size())
        );
    }

    public void displayBatchDetails(String batchId) {
        if (batchId == null || batchId.isEmpty() || !batchMap.containsKey(batchId)) {
            System.out.println("Invalid Batch ID or Batch not found.");
            return;
        }
        List<BatchCheque> cheques = batchMap.get(batchId);
        System.out.println("Details of Batch ID: " + batchId);
        cheques.forEach(cheque -> 
            System.out.println("Account Number: " + cheque.getAccountNumber() +
                               ", Cheque Number: " + cheque.getChequeNumber() +
                               ", Currency: " + cheque.getCurrency() +
                               ", Amount: " + cheque.getAmount() +
                               ", Signature: " + cheque.getSignature())
        );
    }

    public void markTransactionStuck(String chequeNumber) {
        if (chequeNumber == null || chequeNumber.isEmpty()) {
            System.out.println("Invalid Cheque Number. Please provide a valid input.");
            return;
        }
        if (stuckTransactions.contains(chequeNumber)) {
            System.out.println("Cheque Number " + chequeNumber + " is already marked as stuck.");
            return;
        }
        stuckTransactions.add(chequeNumber);
        System.out.println("Cheque Number " + chequeNumber + " has been marked as stuck.");
    }

    public void resetStuckTransaction(String chequeNumber) {
        if (chequeNumber == null || chequeNumber.isEmpty()) {
            System.out.println("Invalid Cheque Number. Please provide a valid input.");
            return;
        }
        if (!stuckTransactions.contains(chequeNumber)) {
            System.out.println("Cheque Number " + chequeNumber + " is not marked as stuck.");
            return;
        }
        stuckTransactions.remove(chequeNumber);
        System.out.println("Cheque Number " + chequeNumber + " has been reset from stuck transactions.");
    }

    public void displayStuckTransactions() {
        if (stuckTransactions.isEmpty()) {
            System.out.println("No stuck transactions available.");
            return;
        }
        System.out.println("List of stuck transactions:");
        stuckTransactions.forEach(chequeNumber -> 
            System.out.println("Cheque Number: " + chequeNumber)
        );
    }
}