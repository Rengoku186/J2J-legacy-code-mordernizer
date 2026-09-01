package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SignatureVerificationService {

    private final Map<String, String> accountSignatures = new ConcurrentHashMap<>();

    public SignatureVerificationService() {
        // Initialize with sample data if needed
        accountSignatures.put("1234567890", "sampleSignature1");
        accountSignatures.put("0987654321", "sampleSignature2");
    }

    /**
     * Verifies if the provided signature matches the one on file for the given account number.
     * If no signature is on file, the provided signature is stored and considered valid.
     *
     * @param accountNumber The account number to verify.
     * @param signature     The signature to verify.
     * @return true if the signature matches or is newly stored, false otherwise.
     */
    public boolean verifySignature(String accountNumber, String signature) {
        if (accountSignatures.containsKey(accountNumber)) {
            // Compare the provided signature with the stored signature
            return accountSignatures.get(accountNumber).equals(signature);
        } else {
            // No signature on file, store the provided signature
            accountSignatures.put(accountNumber, signature);
            return true;
        }
    }

    /**
     * Updates the signature on file for a given account number.
     *
     * @param accountNumber The account number for which the signature is to be updated.
     * @param newSignature  The new signature to be stored.
     */
    public void updateSignature(String accountNumber, String newSignature) {
        if (accountNumber == null || newSignature == null || accountNumber.isEmpty() || newSignature.isEmpty()) {
            throw new IllegalArgumentException("Account number and signature cannot be null or empty.");
        }
        accountSignatures.put(accountNumber, newSignature);
    }
}