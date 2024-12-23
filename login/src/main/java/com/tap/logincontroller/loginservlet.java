package com.tap.logincontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.UserDao;
import com.tap.daoimpl.UserDaoImpl;
import com.tap.model.User;

/**
 * Servlet implementation class loginservlet
 */

public class loginservlet extends HttpServlet 
{
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		UserDao udao=new UserDaoImpl();
		
		User user=udao.getUserByemail(email);
		
		System.out.println("user"+ user);
		if(user!=null)
		{
			if(password.equals(user.getPassword()))
			{
				session =req.getSession();
				session.setAttribute("name", user.getUsername());
				session.setAttribute("user", user);
				resp.sendRedirect("Homeservlet");
			}
			else 
			{
				resp.sendRedirect("incorrectpwd.jsp");
			}
		}
		else 
		{
			resp.sendRedirect("register.jsp");
		}
	}
}
