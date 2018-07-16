package com.yue.servlet;


import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class PrimitiveServlet implements Servlet{

    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init servlet");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service servlet");
        PrintWriter writer = servletResponse.getWriter();
        System.out.println(writer);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("destroy servlet");
    }
}
