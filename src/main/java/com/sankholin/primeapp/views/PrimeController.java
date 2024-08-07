package com.sankholin.primeapp.views;

import com.sankholin.primeapp.model.Prime;
import com.sankholin.primeapp.model.PrimeService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Named
@ViewScoped
public class PrimeController implements Serializable {

    @Inject
    private PrimeService primeService;

    private List<Prime> primes;

    private Prime prime;

    @PostConstruct
    public void init() {
        System.out.println("\tPrime view will be constructed.");
        primes = primeService.getPrimes();
        prime = new Prime();
        prime.setId(UUID.randomUUID().toString());
    }

    @PreDestroy
    private void destroy() {
        System.out.println("\tPrime view will be destroyed.");
    }

    public String process() {
        primeService.addPrime(prime);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  "Added Message: " + prime.getMessage()));
        return "prime";
    }

    public List<Prime> getPrimes() {
        return primes;
    }

    public Prime getPrime() {
        return prime;
    }

    public void setPrime(Prime prime) {
        this.prime = prime;
    }
}
