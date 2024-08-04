package com.sankholin.baseapp;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class BaseView {

    @Inject
    private BaseService baseService;

    private String message;

    @PostConstruct
    public void init() {
        message = "Hello from CDI discovered JSF bean! Calling injected BaseService: " + baseService.add(2, 3);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("\tView will be destroyed right away because of @RequestScoped!");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
