<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.Order" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url("https://img.freepik.com/premium-photo/food-background-cooking-old-background-free-copy-space-top-view_187166-27896.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            color: #333;
        }

        .container {
            max-width: 700px;
            margin: 50px auto;
            padding: 25px;
            background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent white */
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            border: 1px solid #e6e6e6;
        }

        .success-message {
            text-align: center;
            background-color: #9B3FB6; /* Background color */
            color: #006400; /* Text color */
            padding: 20px;
            border-radius: 8px;
            margin-bottom: 20px;
        }

        .success-message h1 {
            font-size: 24px;
            margin-bottom: 10px;
        }

        .success-message p {
            font-size: 16px;
            margin: 5px 0;
        }

        .order-summary {
            margin-top: 20px;
        }

        .order-summary h2 {
            font-size: 20px;
            margin-bottom: 15px;
            color: #333;
        }

        .order-summary p {
            font-size: 16px;
            margin: 10px 0;
        }

        .actions {
            margin-top: 30px;
            text-align: center;
        }

        .actions .btn {
            text-decoration: none;
            color: #fff;
            background-color: #00796b; /* New button color */
            padding: 10px 20px;
            border-radius: 5px;
            margin: 5px;
            display: inline-block;
            transition: background-color 0.3s;
        }

        .actions .btn:hover {
            background-color: #005c51; /* Slightly darker shade on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="success-message">
            <h1>Order Placed Successfully!</h1>
            <%
                // Retrieve the order object from the session
                Order order = (Order) session.getAttribute("order");
                if (order != null) {
            %>
                <p><strong>Restaurant ID:</strong> <%= order.getRestaurantid() != 0 ? order.getRestaurantid() : "Not Available" %></p>
                <p><strong>Total Amount:</strong> ₹<%= String.format("%.2f", order.getTotalamount()) %></p>
                <p><strong>Payment Option:</strong> <%= order.getPaymentoption() %></p>
            <% 
                } else {
            %>
                <p>Order details not found. Please try again.</p>
            <% 
                }
            %>
        </div>
        <div class="order-summary">
            <h2>Thank You!</h2>
            <p>Your order has been placed successfully. You will receive a confirmation email and SMS shortly.</p>
        </div>
        <div class="actions">
            <a href="trackOrder.jsp" class="btn">Track Your Order</a>
            <a href="OrderHistoryservlet" class="btn">View Order History</a>
        </div>
    </div>
</body>
</html>
