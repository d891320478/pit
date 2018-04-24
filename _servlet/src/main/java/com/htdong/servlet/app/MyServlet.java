package com.htdong.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author htdong
 * @date 2018年4月24日 下午7:27:43
 */

@WebServlet(name = "myServlet", urlPatterns = { "/start" })
public class MyServlet implements Servlet {

    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<body>hello world!</body>");
    }

    @Override
    public String getServletInfo() {
        return "servlet start";
    }

    @Override
    public void destroy() {
    }

}
