package com.cedro.cryptopricetracker;

import com.cedro.cryptopricetracker.model.CryptoPrice;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptoController {

    public CryptoPrice getCryptoPrice(String symbol) {
        symbol = symbol.toUpperCase()+"TUSD";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CryptoPrice> response = restTemplate.getForEntity(
                "https://api.binance.com/api/v3/ticker/price?symbol={symbol}",
                CryptoPrice.class,
                symbol);

        return response.getBody();
    }
}
