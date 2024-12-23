<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.tap.model.User" %>
<%@ page import="com.tap.model.Restaurant" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Header with Navigation</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }
        .header {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 4px 20px;
            color: white;
            background-image: url('https://th.bing.com/th/id/OIP.gzD2f2FW89iWwVMblhGA5QHaB1?pid=ImgDet&w=474&h=117&rs=1');
            background-size: cover;
            background-position: center;
            height: 150px;
        }
        .nav-buttons {
            display: flex;
            gap: 20px;
        }
        .nav-buttons a {
            text-decoration: none;
            color: white;
            font-size: 16px;
            padding: 10px 20px;
            background-color: rgba(0, 77, 64, 0.8);
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .nav-buttons a:hover {
            background-color: rgba(0, 47, 39, 0.8);
        }
        .logo {
            font-size: 32px;
            font-weight: bold;
            flex-grow: 1;
            text-align: center;
        }
        .hero {
            position: relative;
            background-image: url('https://granadarestaurant.ca/assets/img/hero/hero_bg_1_1.jpg');
            background-size: cover;
            background-position: center;
            height: 400px; /* Reduced height from 800px to 400px */
            display: flex;
            align-items: flex-start;
            justify-content: center;
            color: white;
            text-align: center;
        }
        .hero span {
            position: relative;
            z-index: 2;
            font-size: 32px;
            font-weight: bold;
            margin-top: 100px; /* Adjust this value to control vertical position */
        }
        .hero::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5); /* Optional: Dark overlay */
            z-index: 1;
        }
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            margin: 20px;
        }
        .card {
            background-image: url('https://th.bing.com/th/id/OIP.WJLMO13n11uMQuHzoLOrqAHaEK?w=287&h=180&c=7&r=0&o=5&pid=1.7');
            background-size: cover;
            background-position: center;
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 20px;
            margin: 15px;
            width: 300px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: 0.3s;
            text-align: center;
            color: white;
        }
        .card:hover {
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }
        .btn-view-menu {
            display: inline-block;
            padding: 10px 15px;
            color: #ffffff;
            background-color: #00796b;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .btn-view-menu:hover {
            background-color: #004d40;
        }
    </style>
</head>
<body>
    <div class="header">
        <div class="logo">
            WELCOME TO TAP FOODS
        </div>
        <div class="nav-buttons">
            <a href="login.jsp">Sign In</a>
            <a href="Cart.jsp">Cart</a>
        </div>
    </div>

    <div class="hero">
        <span>Enjoy Delicious Food at TAP FOODS!</span>
    </div>

    <div class="container">
        <%
        ArrayList<Restaurant> restlist = (ArrayList<Restaurant>) session.getAttribute("restlist");
        if (restlist != null && !restlist.isEmpty()) {
            for (Restaurant r : restlist) {
        %>
        <div class="card">
            <img src="<%= r.getImgPath() %>" alt="<%= r.getName() %>">
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
