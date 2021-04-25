package com.wangjie.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "RegisterServlet",value = "/register")
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("-->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email= request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");

        try {
            Statement st = con.createStatement();
            String sql = "insert into userdb(username,password,email,gender,birthdate)" + "values('" + username + "','" + password + "','"
                     + email + "','" + gender + "','" + birthdate + "')";
            System.out.println("sql" + sql);
            int n = st.executeUpdate(sql);
            System.out.println("n-->" + n);
            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}