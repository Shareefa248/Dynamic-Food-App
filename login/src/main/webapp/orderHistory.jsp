<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="com.tap.model.OrderHistory,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order History</title>
<style>
    body {
        margin: 0;
        font-family: Arial, sans-serif;
        background-image: url("https://img.freepik.com/free-photo/ingredients-cooking-italian-kitchen_1220-5098.jpg");
        background-size: cover;
        background-repeat: no-repeat;
        background-attachment: fixed;
        color: #fff;
        display: flex;
        justify-content: center; /* Center horizontally */
        align-items: center; /* Center vertically */
        height: 100vh;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
        color: #fff; /* White color for the title */
    }

    .container {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        justify-content: center; /* Align items in the container */
    }

    .history-card {
        background-color: rgba(0, 0, 0, 0.8); /* Semi-transparent dark background */
        border: 1px solid #444;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        padding: 15px 20px;
        display: flex;
        flex-direction: column;
        width: 300px;
        transition: transform 0.3s ease;
        color: #fff; /* White text inside the card */
    }

    .history-card:hover {
        transform: translateY(-5px);
        box-shadow: 0 6px 10px rgba(0, 0, 0, 0.3);
    }

    .history-card h3 {
        margin: 0 0 10px;
        font-size: 18px;
        color: #1abc9c; /* Teal for the order ID links */
    }

    .history-card p {
        margin: 5px 0;
        font-size: 14px;
    }

    .history-card a {
        text-decoration: underline; /* Underline the clickable links */
        color: #1abc9c; /* Teal for the clickable links */
        font-weight: bold;
    }

    .history-card a:hover {
        color: #16a085; /* Slightly darker teal on hover */
    }
</style>
</head>
<body>
<div>
    <h1>Your Order History</h1>
    <div class="container">
    <%
        List<OrderHistory> orderHistoryList = (List<OrderHistory>) session.getAttribute("orderHistoryList");
        if (orderHistoryList != null && !orderHistoryList.isEmpty()) {
            for (OrderHistory oh : orderHistoryList) {
    %>
        <div class="history-card">
            <h3>Order ID: <a href="orderNumber?oid=<%= oh.getOid() %>"><%= oh.getOid() %></a></h3>
            <p><strong>Order Date:</strong> <%= oh.getDate() %></p>
            <p><strong>Total Amount:</strong> ₹<%= oh.getTotal() %></p>
            <p><strong>Status:</strong> <%= oh.getStatus() %></p>
        </div>
    <%
            }
        } else {
    %>
        <p style="text-align: center; width: 100%;">No order history found.</p>
    <%
        }
    %>
    </div>
</div>
</body>
</html>
