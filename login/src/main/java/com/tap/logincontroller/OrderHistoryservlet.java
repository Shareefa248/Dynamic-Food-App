package com.tap.logincontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.OrderHistoryDaoImpl;
import com.tap.model.OrderHistory;
import com.tap.model.User;

/**
 * Servlet implementation class OrderHistoryservlet
 */
//@WebServlet("/OrderHistoryservlet")
public class OrderHistoryservlet extends HttpServlet
{
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();

    
        User user = (User) session.getAttribute("user");
        int userId = user.getUser_id();
        System.out.println("User ID: " + userId);

        OrderHistoryDaoImpl orderHistoryDao = new OrderHistoryDaoImpl();
        try
        {
            List<OrderHistory> orderHistoryList = orderHistoryDao.getOrderHistory(userId);
            System.out.println("Order History List: " + orderHistoryList);

            session.setAttribute("orderHistoryList", orderHistoryList);

            response.sendRedirect("orderHistory.jsp");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
