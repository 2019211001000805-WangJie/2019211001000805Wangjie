package com.wangjie.week5.demo;

import com.wangjie.dao.UserDao;
import com.wangjie.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
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
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        ResultSet rs = null;
        PreparedStatement pst=null;
        boolean t = false;
        try {
            String sql = "select * from userdb where username=? and password=?";
            pst= con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs.next()) {
                t = true;
                request.setAttribute("username", rs.getString("Username"));
                request.setAttribute("password", rs.getString("password"));
                request.setAttribute("gender", rs.getString("Gender"));
                request.setAttribute("birthDate", rs.getString("BirthDate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(con,username,password);
            if(user!=null){
                request.setAttribute("user","user");
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }
            else{
                request.setAttribute("message","username or password error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

