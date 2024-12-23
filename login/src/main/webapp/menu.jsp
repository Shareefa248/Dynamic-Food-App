<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu List</title>
    <style>
        /* Background and layout styling */
        body {
            background-image: url('https://thumbs.dreamstime.com/b/asian-food-background-various-ingredients-rustic-stone-top-view-vietnam-thai-cuisine-148762904.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            font-family: Arial, sans-serif;
            color: #333;
            margin: 0;
            padding: 20px;
        }

        h1 {
            display: flex;
            justify-content: space-between;
            align-items: center;
            color: white; /* White color for text */
            padding: 15px;
            background-color: rgba(0, 0, 0, 0.7); /* Add a background for better contrast */
            border-radius: 8px;
            margin-bottom: 20px;
            font-size: 1.5em; /* Uniform size for all header elements */
        }

        .header-links a {
            text-decoration: none;
            color: white; /* Ensure links are white */
            font-size: 1em; /* Uniform font size */
            margin: 0 10px; /* Add some spacing between links */
        }

        .menu-container {
            display: flex;
            flex-direction: column; /* Ensure each item appears on a new line */
            align-items: stretch; /* Stretch items to fill the container */
            gap: 20px; /* Add space between menu items */
            width: 100%;
        }

        .menu-item {
            background-color: rgba(255, 255, 255, 0.9);
            border: 1px solid #ddd;
            padding: 12px;
            border-radius: 8px;
            width: 60%; /* Reduced width to make it smaller */
            height: 150px; /* Set reduced height */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin: 0 auto; /* Center alignment */
            display: flex;
            flex-direction: row; /* Align items horizontally */
            justify-content: space-between; /* Space between details and image */
            align-items: center; /* Vertically center align */
        }

        .menu-item:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
        }

        .menu-item .details {
            flex: 1; /* Allow details to take available space */
            text-align: left;
            padding-right: 10px; /* Add some padding between details and image */
        }

        .menu-item img {
            width: 150px; /* Set specific width */
            height: 120px; /* Set specific height */
            object-fit: cover; /* Ensure the image is properly scaled without distortion */
            border-radius: 8px;
        }

        .menu-item h3 {
            margin: 0;
            font-size: 1.3em;
            color: #4b79a1;
        }

        .menu-item p {
            margin: 5px 0;
            font-size: 1em;
        }

        .menu-item .description {
            color: #2c3e50;
        }

        .menu-item .price {
            font-weight: bold;
            color: #283e51;
            font-size: 1em;
        }

        .menu-item .quantity-label {
            color: #8e44ad;
            font-size: 0.9em;
        }

        .add-to-cart-btn {
            margin-top: 12px;
            padding: 8px 16px;
            background-color: #dc3545;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
        }

        .add-to-cart-btn:hover {
            background-color: #c82333;
        }

        .quantity-input {
            width: 40px;
            font-size: 0.9em;
            padding: 5px;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>
        <div class="header-links">
            <a href="home.jsp">Back to Restaurant</a>
        </div>
        <span>Menu Items</span>
        <div class="header-links">
            <a href="frontpage.jsp">Back to Home</a>
        </div>
    </h1>

    <div class="menu-container">
        <%
            List<Menu> menuList = (List<Menu>) session.getAttribute("menulist");
            if (menuList != null) {
                for (Menu m : menuList) {
        %>
                    <div class="menu-item">
                        <!-- Item details on the left -->
                        <div class="details">
                            <h3><%= m.getItemname() %></h3>
                            <p class="description">Description: <%= m.getDescription() %></p>
                            <p class="price">Price: $<%= m.getPrice() %></p>
                            
                            <!-- Add to cart form -->
                            <form action="cart?itemId=<%= m.getMenuid() %>" method="post">
                                <span class="quantity-label">Quantity:</span>
                                <input type="number" name="quantity" value="1" min="1" class="quantity-input" />
                                <br>
                                <input type="submit" value="Add to Cart" class="add-to-cart-btn" />
                                <input type="hidden" name="act" value="add" />
                            </form>
                        </div>

                        <!-- Display image on the right -->
                        <img src="<%= m.getImgpath() != null ? m.getImgpath() : "default-image-url.jpg" %>" 
                             alt="<%= m.getItemname() %>" />
                    </div>
        <%
                }
            } else {
        %>
                <p>No menu available for this restaurant.</p>
        <%
            }
        %>
    </div>
</body>
</html>