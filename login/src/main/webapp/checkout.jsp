<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.tap.model.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout Page</title>
    <style>
        /* Global styles */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: Arial, sans-serif;
            background-image: url("https://img.freepik.com/premium-photo/chalkboard-with-dinner-menu-background_670382-173444.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            color: #fff; /* White text color */
        }

        /* Checkout container styles */
        .checkout-container {
            max-width: 800px;
            margin: 40px auto;
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.8); /* Semi-transparent black background */
            border: 1px solid #666; /* Dark gray border */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            color: #fff; /* White text color */
        }

        /* Item table styles */
        .item-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        .item-table th, .item-table td {
            border: 1px solid #666;
            padding: 10px;
            text-align: left;
        }

        .item-table th {
            background-color: #555; /* Dark gray background */
            color: #fff; /* White text color */
        }

        .total {
            font-size: 18px;
            font-weight: bold;
            text-align: right;
            margin-top: 20px;
        }

        /* Form styles */
        form {
            margin-top: 20px;
        }

        form label {
            display: block;
            margin-bottom: 10px;
        }

        form textarea, form select {
            width: 100%;
            padding: 10px;
            border: 1px solid #666;
            margin-bottom: 15px;
        }

        form input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #337ab7;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        form input[type="submit"]:hover {
            background-color: #23527c;
        }
    </style>
</head>
<body>
<div class="checkout-container">
    <h2>Checkout</h2>
    <table class="item-table">
        <tr>
            <th>Item Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Subtotal</th>
        </tr>
        <%! double totalAmount = 0; %>
        <%
            Cart cartObj = (Cart) session.getAttribute("cart");
            if (cartObj != null && !cartObj.getCart().isEmpty()) {
                for (CartItem item : cartObj.getCart().values()) {
                    double subtotal = item.getPrice() * item.getQuantity();
                    totalAmount += subtotal;
        %>
        <tr>
            <td><%= item.getName() %></td>
            <td><%= item.getQuantity() %></td>
            <td><%= String.format("%.2f", item.getPrice()) %></td>
            <td><%= String.format("%.2f", subtotal) %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="4">Your cart is empty.</td>
        </tr>
        <%
            }
        %>
    </table>
    <h3 class="total">TotalAmount: <%= String.format("%.2f", totalAmount) %></h3>
    
    <form action="PlaceOrderServlet" method="post">
        <input type="hidden" name="total" value="<%= String.format("%.2f", totalAmount) %>">
        
        <label for="address">Delivery Address</label>
        <textarea id="address" name="address" required></textarea>
        
        <label for="paymentoption">Payment Method</label>
        <select name="paymentoption" id="paymentoption" required>
            <option value="Online">Credit Card</option>
            <option value="Online">Debit Card</option>
            <option value="cash">Cash On Delivery</option>
        </select>
        
        <input type="submit" value="Place Order">
    </form>
</div>
</body>
</html>
