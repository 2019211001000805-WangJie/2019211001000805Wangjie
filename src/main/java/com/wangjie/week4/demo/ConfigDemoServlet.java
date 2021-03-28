package com.wangjie.week4.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="name",value="wangjie"),
                @WebInitParam(name="student id",value="2019211001000805"),
        })
public class ConfigDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String S1=getServletConfig().getInitParameter("name");
        String S2=getServletConfig().getInitParameter("student id");
        PrintWriter writer=response.getWriter();
        writer.println("<br>name:"+S1);
        writer.println("<br>student id:"+S2);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
