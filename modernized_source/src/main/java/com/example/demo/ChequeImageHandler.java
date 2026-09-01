package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ChequeImageHandler {

    /**
     * Loads image data from the specified file path.
     *
     * @param filePath The path to the image file.
     * @return A byte array representing the image data, or null if the file could not be loaded.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public byte[] loadImageData(String filePath) throws IOException {
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("File path cannot be null or empty.");
        }

        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new IOException("File not found at the specified path: " + filePath);
        }

        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            throw new IOException("Failed to read image data from file: " + filePath, e);
        }
    }
}