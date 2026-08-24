package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class ChequeImageHandler {

    /**
     * Loads image data from the specified file path.
     *
     * @param filePath The path to the image file.
     * @return A byte array containing the image data, or null if an error occurs.
     */
    public byte[] loadImageData(String filePath) {
        try {
            Path path = Paths.get(filePath);
            if (!Files.exists(path)) {
                System.err.println("File not found: " + filePath);
                return null;
            }
            return Files.readAllBytes(path);
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath + ". " + e.getMessage());
            return null;
        }
    }
}