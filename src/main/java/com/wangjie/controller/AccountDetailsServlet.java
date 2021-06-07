package com.wangjie.controller;

import com.wangjie.dao.OrderDao;
import com.wangjie.dao.UserDao;
import com.wangjie.model.Order;
import com.wangjie.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/accountDetails")
public class AccountDetailsServlet extends HttpServlet {
    private Connection con=null;
    public  void init() throws ServletException{
        con=(Connection)getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session!=null && session.getAttribute("user")!=null){
            User user=(User) session.getAttribute("user");
            int id =user.getId;
            UserDao dao=new UserDao();
            user=dao.findById(con,id);
            request.setAttribute("user",user);
            OrderDao orderDao=new OrderDao();
            List<Order> orderList=orderDao.findByUserId(con,id);
            request.setAttribute("orderList",orderList);
            request.getRequestDispatcher("/WEB-INF/views/accountDetails.jsp").forward(request,response);
        }else{
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
