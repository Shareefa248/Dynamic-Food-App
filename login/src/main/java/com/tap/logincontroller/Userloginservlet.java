package com.tap.logincontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Userloginservlet
 */
public class Userloginservlet extends HttpServlet
{
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException 
	    {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();

	        String username = request.getParameter("username");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        try
	        {
	            // Database connection setup
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/online_food_delivery", "root", "Shareefa@248");

	            // Query to check if user exists
	            String query = "SELECT * FROM users WHERE username = ? AND email = ? AND password = ?";
	            PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setString(1, username);
	            pstmt.setString(2, email);
	            pstmt.setString(3, password);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next())
	            {
	                // User found, create a session and display user details
	                HttpSession session = request.getSession();
	                session.setAttribute("username", username);
	                session.setAttribute("email", email);

	                out.println("<h2>Welcome, " + username + "</h2>");
	                out.println("<p>Email: " + email + "</p>");
	                out.println("<p>Login successful!</p>");
	            } 
	            else
	            {
	                
	                out.println("<h3>Invalid login. Please try again or register.</h3>");
	                out.println("<button onclick=\"location.href='signinpage.jsp'\">Login</button>");
	                out.println("<button onclick=\"location.href='register.jsp'\">Register</button>");
	                out.println("<button onclick=\"location.href='cart.jsp'\">View Cart</button>");
	            }

	            // Close resources
	            rs.close();
	            pstmt.close();
	            con.close();

	        }
	        catch (Exception e)
	        {
	            out.println("<p>Error: " + e.getMessage() + "</p>");
	            e.printStackTrace(out);
	        }
	        finally
	        {
	            out.close();
	        }
	    }
}
