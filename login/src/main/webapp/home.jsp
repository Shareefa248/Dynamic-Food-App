<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="com.tap.model.User" %>
<%@ page import="com.tap.model.Restaurant" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Restaurant Cards</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("https://th.bing.com/th/id/OIP.cHRxVHt04S5iRh7ML5T4TgAAAA?rs=1&pid=ImgDetMain");
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            margin: 0;
            padding: 20px;
        }
        .header {
            display: flex;
            justify-content: center;
            align-items: center;
            /*background-image: url("https://www.colordic.org/image/004d40.png");*/
            background-size: cover;
            background-repeat: no-repeat;
            color: white;
            padding: 20px 40px;
            height: 150px;
            width: 100%;
            box-sizing: border-box;
            position: relative;
        }
        .header a {
            position: absolute;
            left: 20px;
            top: 20px;
            color: white;
            text-decoration: none;
            font-size: 16px;
            font-weight: bold;
        }
        .header h1 {
            margin: 0;
            font-size: 32px;
        }
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            margin: 20px;
        }
        .card {
            background-color: #ffffff;
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 20px;
            margin: 15px;
            width: 300px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: 0.3s;
            text-align: center;
        }
        .card:hover {
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }
        .card h3 {
            margin-top: 0;
            color: #00796b;
        }
        .card p {
            margin: 8px 0;
        }
        .card img {
            width: 100%;
            height: auto;
            border-radius: 10px;
            margin-bottom: 15px;
        }
        .status-active {
            color: green;
            font-weight: bold;
        }
        .status-inactive {
            color: red;
            font-weight: bold;
        }
        .btn-view-menu {
            display: inline-block;
            padding: 10px 15px;
            color: #ffffff;
            background-color: #00796b;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
            text-align: center;
        }
        .btn-view-menu:hover {
            background-color: #004d40;
        }
    </style>
</head>
<body>
    <div class="header">
        <a href="frontpage.jsp">&larr; Back to Home</a>
        <h1>
            <% User u = (User)session.getAttribute("user");
               if (u != null) {
                   out.println("Welcome " + u.getUsername());
               } else {
                   out.println("Welcome Guest");
               }
            %>
        </h1>
    </div>
    
    <div class="container">
        <%
        ArrayList<Restaurant> restlist = (ArrayList<Restaurant>) session.getAttribute("restlist");
        if (restlist != null && !restlist.isEmpty()) {
            for (Restaurant r : restlist) {
        %>
        <div class="card">
            <img src="<%= r.getImgPath() %>">
            
            <h3><%= r.getName() %></h3>
            <p><strong>Restaurant ID:</strong> <%= r.getRestaurantid() %></p>
            <p><strong>Cuisine Type:</strong> <%= r.getCuisiveType() %></p>
            <p><strong>Delivery Time:</strong> <%= r.getDeliveryTime() %> minutes</p>
            <p><strong>Status:</strong> 
                <span class="<%= r.isActive() ? "status-active" : "status-inactive" %>">
                    <%= r.isActive() ? "Active" : "Inactive" %>
                </span>
            </p>
            <p><strong>Rating:</strong> <%= r.getRating() %> / 5</p>
            <a href="Menuservlet?restaurantId=<%= r.getRestaurantid() %>" class="btn-view-menu">View Menu</a>
        </div>
        <%
            }
        }
        %>
    </div>
</body>
</html>
