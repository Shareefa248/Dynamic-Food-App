package com.tap.logincontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.MenuDaoImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		
		if(cart == null)
		{
			System.out.println("Cart is null");
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		String action = request.getParameter("act");
		if("add".equals(action))
		{
			cart = addItemToCart(request,cart);
		}
		else if("update".equals(action))
		{
			System.out.println("in update cart servlet");
			cart = updateItem(request,cart);
		}
		else if("remove".equals(action))
		{
			removeItem(request,cart);
		}
		
		session.setAttribute("cart",cart);
		response.sendRedirect("Cart.jsp");
	}
	//akhil@thetapacademy.com
	private Cart addItemToCart(HttpServletRequest request,Cart cart)
	{
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		MenuDaoImpl menuDAO = new MenuDaoImpl();
		Menu menuItem = menuDAO.getMenuById(itemId);
		
		HttpSession session = request.getSession();
		session.setAttribute("resturantId",menuItem.getRestaurantid());
		
		if(menuItem != null)
		{
			CartItem item = new CartItem(
					menuItem.getMenuid(),menuItem.getRestaurantid()
					,menuItem.getItemname(),quantity,menuItem.getPrice());
			cart.addItem(item);
		}
		return cart;
	} 
	private Cart updateItem(HttpServletRequest request, Cart cart)
	{
		
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
		
        cart.updateItem(itemId, quantity);
        
        return cart;
    }

    private Cart removeItem(HttpServletRequest request, Cart cart)
    {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        cart.removeItem(itemId);
        return cart;
    }
	
	
}
