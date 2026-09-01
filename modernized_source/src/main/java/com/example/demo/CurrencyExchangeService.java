package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Getter
@Setter
public class CurrencyExchangeService {

    private Map<String, CurrencyRate> exchangeRateCache = new ConcurrentHashMap<>();
    private static final long CACHE_EXPIRY_TIME_MILLIS = 3600000; // 1 hour in milliseconds
    private static final Map<String, Double> FALLBACK_RATES = Map.of(
            "USD", 1.0,
            "EUR", 0.85,
            "GBP", 0.75,
            "INR", 74.0,
            "JPY", 110.0
    );

    public CurrencyRate getExchangeRate(String currency) {
        if (exchangeRateCache == null || !exchangeRateCache.containsKey(currency)) {
            return fetchFallbackRate(currency);
        }
        CurrencyRate rate = exchangeRateCache.get(currency);
        if (!isCacheValid(rate)) {
            exchangeRateCache.remove(currency);
            return fetchFallbackRate(currency);
        }
        return rate;
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (exchangeRateCache == null || !exchangeRateCache.containsKey(fromCurrency) || !exchangeRateCache.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Exchange rate not available for the given currencies.");
        }
        double fromRate = exchangeRateCache.get(fromCurrency).getRate();
        double toRate = exchangeRateCache.get(toCurrency).getRate();
        return (amount / fromRate) * toRate;
    }

    public Map<String, Double> getDetailedExchangeRates(String currency) {
        if (exchangeRateCache == null || !exchangeRateCache.containsKey(currency)) {
            throw new IllegalArgumentException("Exchange rate not available for the given currency.");
        }
        return exchangeRateCache.get(currency).getDetailedRates();
    }

    public List<String> getSupportedCurrencies() {
        if (exchangeRateCache == null || exchangeRateCache.isEmpty()) {
            return new ArrayList<>(FALLBACK_RATES.keySet());
        }
        return List.copyOf(exchangeRateCache.keySet());
    }

    private boolean isCacheValid(CurrencyRate rate) {
        return rate != null && (System.currentTimeMillis() - rate.getLastUpdated()) < CACHE_EXPIRY_TIME_MILLIS;
    }

    private CurrencyRate fetchFallbackRate(String currency) {
        if (!FALLBACK_RATES.containsKey(currency)) {
            throw new IllegalArgumentException("Currency not supported.");
        }
        double rate = FALLBACK_RATES.get(currency);
        return new CurrencyRate(rate, Map.of("buy", rate * 0.99, "sell", rate * 1.01, "fee", 0.01), System.currentTimeMillis());
    }

    public void updateExchangeRate(String currency, double rate, Map<String, Double> detailedRates) {
        if (currency == null || rate <= 0 || detailedRates == null || detailedRates.isEmpty()) {
            throw new IllegalArgumentException("Invalid exchange rate data.");
        }
        exchangeRateCache.put(currency, new CurrencyRate(rate, detailedRates, System.currentTimeMillis()));
    }

    @Getter
    @Setter
    public static class CurrencyRate {
        private double rate;
        private Map<String, Double> detailedRates;
        private long lastUpdated;

        public CurrencyRate(double rate, Map<String, Double> detailedRates, long lastUpdated) {
            this.rate = rate;
            this.detailedRates = detailedRates;
            this.lastUpdated = lastUpdated;
        }
    }
}