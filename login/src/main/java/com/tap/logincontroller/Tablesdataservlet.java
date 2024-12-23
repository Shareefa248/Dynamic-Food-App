package com.tap.logincontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.OrderDaoImpl;
import com.tap.daoimpl.OrderHistoryDaoImpl;
import com.tap.daoimpl.OrderItemDaoImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Order;
import com.tap.model.OrderHistory;
import com.tap.model.OrderItem;
import com.tap.model.User;


/**
 * Servlet implementation class Tablesdataservlet
 */
@WebServlet("/checkout12")
public class Tablesdataservlet extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	      PrintWriter pw = resp.getWriter();
	      String address = req.getParameter("address");
	      String PaymentMethod = req.getParameter("PaymentMethod");
	      float total = Float.parseFloat(req.getParameter("total"));
	      HttpSession session = req.getSession();
	      Cart ca = (Cart)session.getAttribute("cart");
	      User u = (User)session.getAttribute("loggedInUser");
	      int restaurantId = (Integer)session.getAttribute("restaurantId");
	      Order ot = new Order(restaurantId,u.getUser_id(),total, PaymentMethod);
	      OrderDaoImpl otd = new OrderDaoImpl();
	      int status = otd.insertOrder(ot);
	      if (status == 1)
	      {
	         ot = otd.getSpecificOrder();
	         int orderId = ot.getOid();
	         Iterator var16 = ca.getItems().values().iterator();

	         while(true)
	         {
	            OrderItemDaoImpl oid;
	            OrderItem oye;
	            do
	            {
	               if (!var16.hasNext())
	               {
	                  return;
	               }

	               CartItem cit = (CartItem)var16.next();
	               int menuId = cit.getMenuId();
	               int quantity = cit.getQuantity();
	               float subTotal = cit.getSubTotal();
	               double price = cit.getPrice();
	               oid = new OrderItemDaoImpl();
	               oye = new OrderItem(orderId, menuId, quantity, subTotal);
	               status = oid.addItem(oye);
	            }
	            while(status != 1);

	            ArrayList<OrderItem> al = oid.getItem();
	            Iterator var25 = al.iterator();

	            while(var25.hasNext()) {
	            	OrderItem oi = (OrderItem)var25.next();
	               int orderItemId = oye.getOid();
	               OrderHistoryDaoImpl ohd = new OrderHistoryDaoImpl();
	               OrderHistory oh = new OrderHistory(orderItemId, u.getUser_id(), total);
	               status = ohd.addorderHistory(oh);
	               if (status == 1)
	               {
	                  resp.sendRedirect("ordersuccess.jsp");
	               }
	               else
	               {
	                  resp.sendRedirect("failure.jsp");
	               }
	            }
	         }
	      }
	      else
	      {
	         pw.println("order not placed");
	      }
	   }
}
