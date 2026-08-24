package com.example.demo;

import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ChequePrintingService {

    public void printCheque(String payeeName, double amount, Date chequeDate, String accountNumber, String chequeNumber, String bankName) {
        // Method implementation goes here
    }
}