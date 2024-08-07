package com.sankholin.primeapp.rest;

import com.sankholin.primeapp.model.Prime;
import com.sankholin.primeapp.model.PrimeService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Path("/prime")
public class PrimeEndpoint {

    @Inject
    private PrimeService primeService;

    @GET
    @Path("/simple")
    public String simple() {
        return "Simple Prime Service";
    }

    @GET
    @Path("/getPrimes")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Prime> getPrimes() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1); //mimic backend service loading
        return primeService.getPrimes();
    }
}
