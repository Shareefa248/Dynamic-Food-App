<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.OrderItem, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Details</title>
<style>
  body {
    background-image: url("https://img.freepik.com/premium-photo/cooking-background-vegetables-spices-kitchen-utensils-stone-background-top-view_187166-44473.jpg");
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    font-family: Arial, sans-serif;
    color: white;
    display: flex;
    flex-direction: column;
    justify-content: flex-start; /* Changed to flex-start to align header at the top */
    align-items: center;
    height: 100vh;
  }
  .header {
    display: flex;
     /* Distributes space between Back to Order History and Welcome to Orders */
    align-items: center;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.7); /* Semi-transparent black background */
    padding: 80px 120px;
  }
  .header a {
    color: white;
    text-decoration: none;
    padding: 10px 15px;
    background-color: #00796b;
    border-radius: 5px;
    transition: background-color 0.3s ease;
  }
  .header a:hover {
    background-color: #004d40;
  }
  .header h1 {
    color: white;
    margin: 0 320px; /* Added small left margin for spacing */
  }
  .orderItems {
    margin: 20px;
    padding: 15px;
    background-color: rgba(51, 51, 51, 0.6); /* Semi-transparent dark background that blends with image */
    border-radius: 8px;
  }
  table {
    width: 100%;
    border-collapse: collapse;
  }
  td {
    padding: 10px;
    border-bottom: 1px solid #555;
  }
  h1 {
    margin-bottom: 20px;
    text-align: center;
    color: white;
  }
  input[type="button"] {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  input[type="button"]:hover {
    background-color: #45a049;
  }
</style>
</head>
<body>

<div class="header">
  <a href="orderHistory.jsp">Back to Order History</a>
  <h1>Welcome to Orders</h1>
</div>

<%
    ArrayList<OrderItem> orderItems = (ArrayList<OrderItem>) session.getAttribute("OrderItems");
    if (orderItems != null && !orderItems.isEmpty()) {
        for (OrderItem orderItem : orderItems) {
%>
<div class="orderItems">
   <table>
       <tr>
          <td>Menu Id:</td>
          <td><%= orderItem.getMenuId() %></td>
       </tr>
       <tr>
          <td>Quantity:</td>
          <td><%= orderItem.getQuantity() %></td>
       </tr>
       <tr>
          <td>Subtotal:</td>
          <td><%= orderItem.getSubTotal() %></td>
       </tr>
       <tr>
          <td><input type="button" value="Submit"></td>
       </tr>
   </table>
</div>
<%
        }
    } else {
%>
<div>
    <p>No order items found in the session. Please try again later.</p>
</div>
<%
    }
%>

</body>
</html>  
