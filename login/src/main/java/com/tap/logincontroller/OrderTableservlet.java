package com.tap.logincontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.OrderItemDaoImpl;
import com.tap.model.OrderHistory;
import com.tap.model.OrderItem;

/**
 * Servlet implementation class OrderTableservlet
 */
@WebServlet("/orderNumber")
public class OrderTableservlet extends HttpServlet
{
	 PrintWriter pw;

	    public OrderTableservlet()
	    {
	    }

	    @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	    {
	        HttpSession session = req.getSession();
	        this.pw = resp.getWriter();
	        Object obj = session.getAttribute("orderHistoryList");

	        if (obj instanceof OrderHistory)
	        {
	            
	            OrderHistory orderHistory = (OrderHistory) obj;
	            int orderId = orderHistory.getOid();

	            OrderItemDaoImpl oid = new OrderItemDaoImpl();
	            ArrayList<OrderItem> al = oid.getSpecificItem(orderId);
	            System.out.println(al);

	            if (al != null && !al.isEmpty())
	            {
	                session.setAttribute("OrderItems", al);
	                System.out.println("Order items added properly to session.");

	                resp.sendRedirect("orderTable.jsp");
	            }
	            else
	            {
	                this.pw.println("No order items found for the given order ID.");
	            }
	        }
	        else if (obj instanceof ArrayList<?>)
	        {
	            ArrayList<OrderHistory> orderHistoryList = (ArrayList<OrderHistory>) obj;

	            if (!orderHistoryList.isEmpty())
	            {
	                OrderHistory orderHistory = orderHistoryList.get(0);
	                int orderId = orderHistory.getOid();

	                OrderItemDaoImpl oid = new OrderItemDaoImpl();
	                ArrayList<OrderItem> al = oid.getSpecificItem(orderId);

	                if (al != null && !al.isEmpty())
	                {
	                    session.setAttribute("OrderItems", al);
	                    System.out.println("Order items added properly to session.");

	                    resp.sendRedirect("orderTable.jsp");
	                }
	                else
	                {
	                    this.pw.println("No order items found for the given order ID.");
	                }
	            }
	            else
	            {
	                this.pw.println("Order history list is empty.");
	            }
	        }
	        else
	        {
	           
	            this.pw.println("Invalid object type for 'orderHistoryList' in session.");
	        }
	    }
}
