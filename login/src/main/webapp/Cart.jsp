<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.tap.model.Cart, com.tap.model.CartItem" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <style>
        /* Page background and layout styling */
        body {
            background-image: url("https://img.freepik.com/premium-photo/top-view-food-background-with-text-menu-recipe_993599-9390.jpg");
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
            color: #03BB6E;
            margin-bottom: 50px; /* Added spacing below the header */
            font-size: 2em;
        }

        .header-links-container {
            display: flex;
            justify-content: space-between;
            width: 100%;
        }

        .header-link {
            width: 33%;
            text-align: center;
            font-size: 0.8em;
            font-weight: bold;
        }

        .header-link a,
        .header-link form a {
            text-decoration: none;
            color: #BA047D;
            font-size: 1em;
            padding: 5px 15px;
            border: 1px solid #BA047D;
            border-radius: 5px;
            background-color: #f9f9f9;
            text-align: center;
            transition: background-color 0.3s ease, transform 0.2s ease;
            display: inline-block;
        }

        .header-link a:hover,
        .header-link form a:hover {
            background-color: #F3C9E6;
            transform: scale(1.05);
        }

        .cart-container {
            margin: 20px auto;
            width: 80%;
            border-top: 2px solid #ddd; /* Added top border to visually separate */
            padding-top: 20px;
        }

        .cart-header, .cart-item, .cart-footer {
            display: flex;
            justify-content: space-between;
            padding: 12px;
            border: 1px solid #ddd;
            background-color: #f2f2f2;
        }

        .cart-header {
            font-weight: bold;
            color: #004d40;
            text-align: center;
        }

        .cart-item > span,
        .cart-header > span {
            width: 20%; /* Ensure equal spacing for all columns */
            text-align: center;
        }

        .cart-item .cart-actions {
            width: 20%;
            display: flex;
            justify-content: center;
            gap: 5px;
        }

        .cart-footer {
            justify-content: flex-end;
            font-size: 1.2em;
            font-weight: bold;
        }

        .cart-actions input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .cart-actions input[type="submit"]:hover {
            background-color: #218838;
        }

        .cart-actions input[type="submit"].remove {
            background-color: #dc3545;
        }

        .cart-actions input[type="submit"].remove:hover {
            background-color: #c82333;
        }

        .cart-actions input[type="number"] {
            width: 50px; /* Reduced width for increment and decrement boxes */
            padding: 5px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .checkout-btn {
            margin: 20px auto;
            display: block;
            text-align: center;
            padding: 10px 20px;
            background-color: #03BB6E;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1em;
            cursor: pointer;
            text-decoration: none;
            width: fit-content;
        }

        .checkout-btn:hover {
            background-color: #029B57;
        }
    </style>
</head>
<body>
    <h1>
        <div class="header-links-container">
            <div class="header-link">
                <a href="menu.jsp">Add More</a>
            </div>
            <div class="header-link">
                Your Cart
            </div>
            <div class="header-link">
                <form action="Clearcartservlet" method="post" style="display: inline;">
                    <a href="#" onclick="this.closest('form').submit(); return false;">Clear Cart</a>
                </form>
            </div>
        </div>
    </h1>

    <center>
        <div class="cart-container">
            <%
                Cart cartObj = (Cart) session.getAttribute("cart");
                Map<Integer, CartItem> cart = (cartObj != null) ? cartObj.getCart() : null;
                if (cart != null && !cart.isEmpty()) {
                    double totalAmount = 0;
            %>
                <div class="cart-header">
                    <span>Item Name</span>
                    <span>Price</span>
                    <span>Quantity</span>
                    <span>Subtotal</span>
                    <span>Actions</span>
                </div>
                <%
                    for (CartItem item : cart.values()) {
                        double subtotal = item.getPrice() * item.getQuantity();
                        totalAmount += subtotal;
                %>
                <div class="cart-item">
                    <span><%= item.getName() %></span>
                    <span><%= String.format("%.2f", item.getPrice()) %></span>
                    <span><%= item.getQuantity() %></span>
                    <span><%= String.format("%.2f", subtotal) %></span>
                    <div class="cart-actions">
                        <form action="cart" method="post">
                            <input type="hidden" name="itemId" value="<%= item.getMenuId() %>">
                            <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1" required>
                            <input type="hidden" name="act" value="update">
                            <input type="submit" value="Update">
                        </form>
                        <form action="cart" method="post">
                            <input type="hidden" name="itemId" value="<%= item.getMenuId() %>">
                            <input type="hidden" name="act" value="remove">
                            <input type="submit" value="Remove" class="remove">
                        </form>
                    </div>
                </div>
                <%
                    }
                %>
                <div class="cart-footer">
                    Total: $<%= String.format("%.2f", totalAmount) %>
                </div>
                <a href="checkout.jsp" class="checkout-btn">Proceed to Checkout</a>
            <%
                } else {
            %>
                <p>Your cart is empty.</p>
            <%
                }
            %>
        </div>
    </center>
</body>
</html>
 