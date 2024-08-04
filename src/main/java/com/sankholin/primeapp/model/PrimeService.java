package com.sankholin.primeapp.model;

import java.util.List;

public interface PrimeService {
    List<Prime> getPrimes();
    void addPrime(Prime prime);
}
