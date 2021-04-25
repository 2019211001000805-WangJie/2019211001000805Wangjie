package com.wangjie.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloworldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Name:Wangjie");
        writer.println("ID:2019211001000805");
        writer.println("Date and Time Sat Mar 13 15:30:12 CST 2021");
    }
}