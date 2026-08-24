package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class SignatureVerificationService {

    private final Map<String, String> accountSignatures = new HashMap<>();

    public SignatureVerificationService() {
        // Initialize with sample data
        accountSignatures.put("1234567890", "sampleSignature1");
        accountSignatures.put("0987654321", "sampleSignature2");
        accountSignatures.put("1122334455", "sampleSignature3");
    }

    /**
     * Verifies if the provided signature matches the stored signature for the given account number.
     * If no signature is on file, it accepts the new signature and stores it.
     *
     * @param accountNumber The account number to verify the signature for.
     * @param signature     The signature to verify.
     * @return true if the signature matches or is accepted as new, false otherwise.
     */
    public boolean verifySignature(String accountNumber, String signature) {
        if (accountSignatures.containsKey(accountNumber)) {
            String storedSignature = accountSignatures.get(accountNumber);
            if (storedSignature.equals(signature)) {
                return true; // Signature matches
            } else {
                return false; // Signature does not match
            }
        } else {
            // No signature on file, accept the provided signature
            accountSignatures.put(accountNumber, signature);
            return true;
        }
    }

    /**
     * Updates the stored signature for the specified account number.
     *
     * @param accountNumber The account number for which the signature is to be updated.
     * @param newSignature  The new signature to store.
     */
    public void updateSignature(String accountNumber, String newSignature) {
        accountSignatures.put(accountNumber, newSignature);
    }
}