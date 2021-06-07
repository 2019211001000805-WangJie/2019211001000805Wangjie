package com.wangjie.controller;

import com.wangjie.dao.UserDao;
import com.wangjie.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        String Email= request.getParameter("Email");
        String Gender= request.getParameter("Gender");
        Date Birthdate= Date.valueOf(request.getParameter("Birthdate"));
        UserDao userdao=new UserDao();
        User user=null;
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(Email);
        user.setGender(Gender);
        user.setBirthdate(Birthdate);
        try {
            int u=userdao.updateUser(con,user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("user",user);
        request.getRequestDispatcher("accountDetails").forward(request,response);
    }
}
