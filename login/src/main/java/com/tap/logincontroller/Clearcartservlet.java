package com.tap.logincontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.CartDaoImpl;
import com.tap.model.Cart;

/**
 * Servlet implementation class Clearcartservlet
 */
public class Clearcartservlet extends HttpServlet
{
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
	{
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
	 {
        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null)
        {
            cart.getCart().clear(); 
            session.setAttribute("cart", null); 
        }
        response.sendRedirect("Cart.jsp");
    }
}
