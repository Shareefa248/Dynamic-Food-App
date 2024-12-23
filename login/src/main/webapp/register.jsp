<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        body {
            font-family: Arial, sans-serif;
            position: relative;
            background-image: url("https://images.squarespace-cdn.com/content/v1/5d55b5ef392d910001360072/1569254643454-Q06I2YLQ6U1DTLJHRNLF/iStock-821791690.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 250px; /* Reduced width */
            padding: 30px; /* Reduced padding */
            border-radius: 10px;
            background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            color: #00796b; /* Teal color */
            margin-bottom: 15px; /* Reduced margin */
        }
        label {
            display: block;
            margin: 8px 0 5px; /* Reduced spacing */
            color: #00796b; /* Teal color */
        }
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: calc(100% - 16px); /* Adjusted width */
            padding: 8px; /* Reduced padding */
            margin: 8px 0 15px 0; /* Reduced spacing */
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .button {
            background-color: #00796b; /* Teal background */
            color: white;
            padding: 8px; /* Reduced padding */
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            transition: background-color 0.3s ease;
        }
        .button:hover {
            background-color: #004d40; /* Dark teal */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Register Page</h2>
        <form action="Registerservlet" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>
            <label for="role">Role:</label>
            <input type="text" id="role" name="role" required>
            <button type="submit" class="button">Register</button>
        </form>
    </div>
</body>
</html>
