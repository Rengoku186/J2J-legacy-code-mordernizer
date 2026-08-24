package com.example.demo;

import java.security.*;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Service;

@Service
public class CryptographyService {

    private static final String RSA_ALGORITHM = "RSA";
    private static final String AES_ALGORITHM = "AES";

    public byte[] encryptData(byte[] data, String encryptionKey) {
        try {
            SecretKey secretKey = generateSecretKey(AES_ALGORITHM, encryptionKey.getBytes());
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting data: " + e.getMessage(), e);
        }
    }

    public byte[] decryptData(byte[] encryptedData, String encryptionKey) {
        try {
            SecretKey secretKey = generateSecretKey(AES_ALGORITHM, encryptionKey.getBytes());
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(encryptedData);
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting data: " + e.getMessage(), e);
        }
    }

    public String signData(byte[] data, PrivateKey privateKey) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(data);
            byte[] signedData = signature.sign();
            return encodeBase64(signedData);
        } catch (Exception e) {
            throw new RuntimeException("Error signing data: " + e.getMessage(), e);
        }
    }

    public boolean verifySignature(byte[] data, String signature, PublicKey publicKey) {
        try {
            Signature sig = Signature.getInstance("SHA256withRSA");
            sig.initVerify(publicKey);
            sig.update(data);
            byte[] decodedSignature = decodeBase64(signature);
            return sig.verify(decodedSignature);
        } catch (Exception e) {
            throw new RuntimeException("Error verifying signature: " + e.getMessage(), e);
        }
    }

    public SecretKey generateSecretKey(String algorithm, byte[] keyBytes) {
        try {
            return new SecretKeySpec(keyBytes, algorithm);
        } catch (Exception e) {
            throw new RuntimeException("Error generating secret key: " + e.getMessage(), e);
        }
    }

    public String encodeBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public byte[] decodeBase64(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }
}