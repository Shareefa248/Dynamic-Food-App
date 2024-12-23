package com.tap.logincontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.dao.MenuDao;
import com.tap.daoimpl.MenuDaoImpl;
import com.tap.model.Menu;

public class Menuservlet extends HttpServlet 
{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int restaurantId=Integer.parseInt(req.getParameter("restaurantId"));

		MenuDao mdao=new MenuDaoImpl();
		
		List<Menu>menulist=mdao.getRestById(restaurantId);
		
		req.getSession().setAttribute("restaurantId",restaurantId);
		req.getSession().setAttribute("menulist", menulist);
		resp.sendRedirect("menu.jsp");

	}
}
