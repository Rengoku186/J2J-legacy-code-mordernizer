---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_21"
confidence_score: 0.95
external_dependencies: ["exceptionReportManager", "currencyExchangeService", "coreBankingSystemUpdater", "chequeHistoryManager", "chequeStatusManager", "emailNotificationService", "CurrencyRate"]
---

# Documentation for Code Chunk

## Overview
This code chunk is part of a cheque processing system in a banking application. It handles various operations such as simulating delayed cheques, currency exchange rate calculations, updating the core banking system, recording cheque history, and managing cheque statuses. Additionally, it includes a method to cancel cheques and a utility class for enhanced currency exchange services.

## Key Functionalities

### 1. Simulating Delayed Cheques
- **Condition**: If the cheque number ends with '9', the cheque is marked as delayed.
- **Actions**:
  - Reports the delay using `exceptionReportManager.reportException`.
  - Logs the delay using `Logger.info`.
  - Prints a message to the console.

### 2. Currency Exchange Rate Calculations
- **Condition**: If the cheque's currency is not USD (the base currency).
- **Actions**:
  - Fetches detailed exchange rates using `currencyExchangeService.getDetailedExchangeRates`.
  - Logs an error and aborts processing if exchange rates are unavailable.
  - Converts the cheque amount to local currency using the buy rate and applies a fee.
  - Logs the conversion details, including the original amount, exchange rate, fee, and final amount in local currency.

### 3. Updating the Core Banking System
- **Action**: Updates the core banking system with the converted amount using `coreBankingSystemUpdater.updateCoreBankingSystem`.

### 4. Recording Cheque History
- **Action**: Records the cheque details (account number, cheque number, currency, amount, and date) using `chequeHistoryManager.recordCheque`.

### 5. Managing Cheque Status
- **Action**: Sets the cheque status to `PROCESSED` using `chequeStatusManager.setStatus`.
- **Logs**: Logs the successful processing of the cheque.

### 6. Error Handling
- **Action**: Catches exceptions during cheque processing.
  - Logs the error using `Logger.error`.
  - Reports the error using `exceptionReportManager.reportException`.
  - Sends an email notification about the error using `emailNotificationService.sendEmail`.

### 7. Cancelling a Cheque
- **Method**: `cancelCheque`
  - **Parameters**: `accountNumber`, `chequeNumber`
  - **Actions**:
    - Sets the cheque status to `CANCELED` using `chequeStatusManager.setStatus`.
    - Logs the cancellation.
    - Prints a message to the console.
  - **Error Handling**: Logs and prints an error message if the cancellation fails.

## Supporting Class: `CurrencyExchangeService`
This utility class provides enhanced currency exchange functionalities, including:

### Key Methods

#### `getExchangeRate`
- **Purpose**: Fetches the exchange rate for a specific currency relative to USD.
- **Features**:
  - Checks a local cache for the rate.
  - Attempts to fetch the rate from an external API.
  - Falls back to predefined rates if the API is unavailable.
  - Caches the fetched or fallback rate.

#### `convertCurrency`
- **Purpose**: Converts an amount from one currency to another.
- **Process**:
  - Converts the amount to the base currency (USD).
  - Converts the amount from the base currency to the target currency.

#### `getDetailedExchangeRates`
- **Purpose**: Provides detailed exchange rate information, including buy/sell rates and fees.
- **Details**:
  - Calculates buy and sell rates as slight variations of the mid-rate.
  - Calculates a fee as 0.5% of the mid-rate.

## External Dependencies

### 1. `exceptionReportManager`
- **Method**: `reportException`
- **Purpose**: Logs and stores exceptions related to cheque processing.

### 2. `currencyExchangeService`
- **Method**: `getDetailedExchangeRates`
- **Purpose**: Fetches detailed exchange rate information for a given currency.

### 3. `coreBankingSystemUpdater`
- **Method**: `updateCoreBankingSystem`
- **Purpose**: Updates the core banking system with the processed cheque amount.

### 4. `chequeHistoryManager`
- **Method**: `recordCheque`
- **Purpose**: Records the details of processed cheques for future reference.

### 5. `chequeStatusManager`
- **Method**: `setStatus`
- **Purpose**: Updates the status of a cheque (e.g., PROCESSED, CANCELED).

### 6. `emailNotificationService`
- **Method**: `sendEmail`
- **Purpose**: Sends email notifications for errors or other events.

### 7. `CurrencyRate`
- **Purpose**: Represents exchange rate information, including the rate and the last updated timestamp.

## Error Handling
The code includes robust error handling mechanisms to ensure that any issues during cheque processing are logged, reported, and communicated to the relevant parties via email notifications.

## Logging
The `Logger` class is used extensively to log information, errors, and status updates during cheque processing and related operations.