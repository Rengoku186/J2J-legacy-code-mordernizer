package com.example.demo;

import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class ChequePrintingService {

    /**
     * Simulates the printing of a cheque by formatting and displaying the cheque details.
     *
     * @param payeeName    The name of the payee.
     * @param amount       The amount to be paid.
     * @param date         The date of the cheque.
     * @param accountNumber The account number from which the cheque is issued.
     * @param chequeNumber The cheque number.
     * @param bankName     The name of the bank issuing the cheque.
     */
    public void printCheque(String payeeName, double amount, String date, String accountNumber, String chequeNumber, String bankName) {
        try {
            // Parse and format the date
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd MMMM yyyy");
            Date parsedDate = inputDateFormat.parse(date);
            String formattedDate = outputDateFormat.format(parsedDate);

            // Format the amount as currency
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
            String formattedAmount = currencyFormatter.format(amount);

            // Print the cheque details
            System.out.println("--------------------------------------------------");
            System.out.println("                  CHEQUE DETAILS                  ");
            System.out.println("--------------------------------------------------");
            System.out.println("Bank Name: " + bankName);
            System.out.println("Date: " + formattedDate);
            System.out.println("Payee: " + payeeName);
            System.out.println("Amount: " + formattedAmount);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Cheque Number: " + chequeNumber);
            System.out.println("--------------------------------------------------");
            System.out.println("                  END OF CHEQUE                  ");
            System.out.println("--------------------------------------------------");
        } catch (Exception e) {
            System.err.println("Error while printing cheque: " + e.getMessage());
        }
    }
}