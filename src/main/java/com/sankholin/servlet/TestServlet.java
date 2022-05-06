package com.sankholin.servlet;

import com.sankholin.service.ITestService;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "testServlet", urlPatterns = {"/testcdi"})
public class TestServlet extends HttpServlet {

    @Inject
    private ITestService testService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        PrintWriter out = response.getWriter();
        out.println("[TestServlet] Calling injected testService: " + testService.add(2, 3));
        out.close();
    }
}