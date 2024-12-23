package com.tap.logincontroller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.OrderDao;
import com.tap.daoimpl.OrderDaoImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Order;
import com.tap.model.User;

@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet
{
	static Connection con;
	private static String url="jdbc:mysql://localhost:3306/online_food_delivery";
	private static String un="root";
	private static String pwd="Shareefa@248";
	private OrderDao orderDAO;

	@Override
	public void init()
	{
	   orderDAO = new OrderDaoImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
	HttpSession session = request.getSession();
	Cart cart = (Cart) session.getAttribute("cart");
	User user = (User) session.getAttribute("user");
	System.out.println(user);

	if (cart != null && user != null && !cart.getItems().isEmpty())
	{
	// Extract checkout form data
	String paymentoption = request.getParameter("paymentoption");

	// Create and populate the order object
	Order order = new Order();
	order.setUid(user.getUser_id());
	System.out.println(session.getAttribute("resturantId"));
	// System.out.println(Integer.parseInt((String)session.getAttribute("resturantId")));
	order.setRestaurantid((int)session.getAttribute("resturantId"));
	order.setDate(new Date(0));
	order.setPaymentoption(paymentoption);
	order.setStatus("Pending");

	// Add cart items to the order and calculate the total amount
	double totalAmount = 0;
	for (CartItem item : cart.getItems().values())
	{
	// Assuming Order has a method to handle the logic of adding items
//	                order.addOrderItem(item);  (this was throwing error)
	totalAmount += item.getPrice() * item.getQuantity();
	}
	order.setTotalamount(totalAmount);

	// Save the order to the database
	orderDAO.insertOrder(order);

	// Clear the cart and redirect to the order confirmation page
	session.removeAttribute("cart");
	session.setAttribute("order", order);
	System.out.println("Checkout");
	response.sendRedirect("ordersuccess.jsp");
	} 
	else
	{
	response.sendRedirect("Cart.jsp"); // Redirect to cart if it's empty or user is not logged in
	}
	}
}
