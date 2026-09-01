package com.example.demo;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Service
public class CryptographyService {

    private static final String ENCRYPTION_ALGORITHM = "AES";
    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
    private static final int AES_KEY_SIZE = 128;

    /**
     * Encrypts the given data using the provided key.
     *
     * @param data The data to encrypt.
     * @param key  The encryption key.
     * @return The encrypted data as a byte array.
     */
    public byte[] encryptData(byte[] data, String key) {
        try {
            byte[] keyBytes = Base64.getDecoder().decode(key);
            SecretKey secretKey = new SecretKeySpec(keyBytes, ENCRYPTION_ALGORITHM);
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting data", e);
        }
    }

    /**
     * Signs the given data using the provided private key.
     *
     * @param data       The data to sign.
     * @param privateKey The private key used for signing.
     * @return The digital signature as a Base64-encoded string.
     */
    public String signData(byte[] data, String privateKey) {
        try {
            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey key = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(key);
            signature.update(data);
            byte[] signedData = signature.sign();
            return Base64.getEncoder().encodeToString(signedData);
        } catch (Exception e) {
            throw new RuntimeException("Error signing data", e);
        }
    }

    /**
     * Verifies the digital signature of the given data using the provided public key.
     *
     * @param data      The data to verify.
     * @param signature The digital signature to verify.
     * @param publicKey The public key used for verification.
     * @return True if the signature is valid, false otherwise.
     */
    public boolean verifySignature(byte[] data, String signature, String publicKey) {
        try {
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey key = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
            Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
            sig.initVerify(key);
            sig.update(data);
            byte[] signatureBytes = Base64.getDecoder().decode(signature);
            return sig.verify(signatureBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error verifying signature", e);
        }
    }

    /**
     * Generates a new AES encryption key.
     *
     * @return The generated AES key as a Base64-encoded string.
     */
    public String generateEncryptionKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ENCRYPTION_ALGORITHM);
            keyGenerator.init(AES_KEY_SIZE);
            SecretKey secretKey = keyGenerator.generateKey();
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException("Error generating encryption key", e);
        }
    }

    /**
     * Generates a new RSA key pair for signing and verification.
     *
     * @return A KeyPair object containing the private and public keys.
     */
    public KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            throw new RuntimeException("Error generating key pair", e);
        }
    }
}