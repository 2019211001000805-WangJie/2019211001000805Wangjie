package com.wangjie.controller;

import com.wangjie.dao.OrderDao;
import com.wangjie.model.Item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "OrderDetailsServlet", value = "/OrderDetailsServlet")
public class OrderDetailsServlet extends HttpServlet {
    private Connection con=null;
    public  void init() throws ServletException{
        con=(Connection)getServletContext().getAttribute("con");
    }
    public void destroy() {
        super.destroy();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int orderId=request.getParameter("orderId")!=null?
            Integer.parseInt(request.getParameter("orderId")):0;
    Item item=new Item();
        OrderDao dao=new OrderDao();
        List<Item> items=dao.findItemsByOrderId(con,orderId);
        request.setAttribute("itemsList",items);
        String  path="orderDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }
}
