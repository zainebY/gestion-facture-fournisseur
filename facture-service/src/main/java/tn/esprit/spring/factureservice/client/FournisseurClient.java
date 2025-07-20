package tn.esprit.spring.factureservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class FournisseurClient {

    private final RestTemplate restTemplate;

    @Value("${fournisseur.service.url}")
    private String fournisseurServiceUrl;

    public FournisseurClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "fournisseurCB", fallbackMethod = "fallbackGetFournisseurName")
    public String getFournisseurName(Long fournisseurId) {
        String url = fournisseurServiceUrl + "/" + fournisseurId;
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackGetFournisseurName(Long fournisseurId, Throwable ex) {
        return "Fournisseur temporarily unavailable";
    }
}