package com.esprit.fournisseur.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalClient {

    private final RestTemplate restTemplate;

    public ExternalClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "externalServiceCB", fallbackMethod = "fallbackMethod")
    public String callExternalService(Long id) {
        // This should call facture-service on port 8082
        String url = "http://localhost:8082/api/factures/" + id;
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackMethod(Long id, Throwable ex) {
        return "External service temporarily unavailable";
    }
}
