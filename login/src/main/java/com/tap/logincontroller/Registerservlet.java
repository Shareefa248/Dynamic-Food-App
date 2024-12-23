package com.tap.logincontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.dao.UserDao;
import com.tap.daoimpl.UserDaoImpl;
import com.tap.model.User;

/**
 * Servlet implementation class Registerservlet
 */
@WebServlet("/register")
public class Registerservlet extends HttpServlet {
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Retrieve form data
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String role = request.getParameter("role");

        // Create User object
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(address);
        user.setRole(role);

        // Insert user into the database
        UserDao userDao = new UserDaoImpl();
        int result = userDao.insertUser(user);

        // Check insertion result and respond
        if (result > 0) {
            // Successful registration
            response.sendRedirect("signinpage.jsp"); // Redirect to sign-in page
        } else {
            // Registration failed
            response.sendRedirect("register.jsp?error=Registration failed. Please try again.");
        }
    }
}
