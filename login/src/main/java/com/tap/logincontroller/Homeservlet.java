package com.tap.logincontroller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.Restaurant;

/**
 * Servlet implementation class Homeservlet
 */

public class Homeservlet extends HttpServlet 
{
	ArrayList<Restaurant>restlist=new ArrayList<Restaurant>();
	 String fetchall="select * from restaurant";
	 Connection con;
	 Statement stmt;
	 ResultSet resultset;
	private HttpSession session;
	@Override
	public void init() throws ServletException 
	  {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","Shareefa@248");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  }
		
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		try
		{
			stmt=con.createStatement();
			resultset=stmt.executeQuery(fetchall);
			while(resultset.next())
			{
				restlist.add(new Restaurant(resultset.getInt("restaurantid"),resultset.getString("name"),resultset.getString("cuisiveType"),resultset.getInt("deliveryTime"),
						resultset.getBoolean("isActive"),resultset.getInt("rating"),resultset.getString("imgPath")));
			}
			session=req.getSession();
			session.setAttribute("restlist",restlist);
			resp.sendRedirect("home.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
