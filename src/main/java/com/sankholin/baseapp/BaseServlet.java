package com.sankholin.baseapp;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "baseServlet", urlPatterns = {"/base"})
public class BaseServlet extends HttpServlet {

    @Inject
    private BaseService baseService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("BaseServlet calls CDI injected BaseService: " + baseService.add(2, 3));
        out.close();
    }
}
