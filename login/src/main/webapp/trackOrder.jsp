<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-image: url('https://i.pinimg.com/originals/e6/7d/af/e67daf68a6e8f6d4a9283cb7d64b098c.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: white;
        }
        .message-container {
            text-align: center;
            background: rgba(0, 0, 0, 0.6); /* Semi-transparent overlay */
            padding: 50px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        h1 {
            font-size: 36px;
            margin: 0 0 10px;
        }
        .message {
            font-size: 18px;
        }
    </style>
</head>
<body>
    <div class="message-container">
        <h1>Your Order is on the Way!</h1>
        <p class="message">Thank you for choosing TAP Foods. Sit back, relax, and we’ll deliver your delicious food shortly!</p>
    </div>
</body>
</html>
