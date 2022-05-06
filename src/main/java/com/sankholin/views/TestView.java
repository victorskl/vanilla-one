package com.sankholin.views;

import com.sankholin.service.ITestService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class TestView {

    @Inject
    private ITestService testService;

    private String message;

    @PostConstruct
    public void init() {
        message = "Hello from CDI discovered JSF backing bean! Calling injected testService: " + testService.add(2, 3);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("\tTest view will be destroyed right away because of @RequestScoped!");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}