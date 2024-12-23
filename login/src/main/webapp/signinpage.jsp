<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign In Page</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        body {
            position: relative;
            font-family: Arial, sans-serif;
            background-image: url('https://th.bing.com/th/id/R.783ecca519ae0a9e6828595c7682a6bb?rik=1TysI%2flq4qz5hw&riu=http%3a%2f%2fwww.pixelstalk.net%2fwp-content%2fuploads%2f2016%2f08%2fFast-food-backgrounds-free-download.jpg&ehk=VN0hGMNRFLcAvvFfp4ePGsV38KfupnWKf0jLzqcaS90%3d&risl=&pid=ImgRaw&r=0');
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
        .card {
            border-radius: 10px;
            padding: 40px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
            background-color: #f9f9f9;
        }
        .card h2 {
            color: #00796b;
            margin-bottom: 20px;
        }
        .card input[type="text"],
        .card input[type="email"],
        .card input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .card button {
            background-color: #00796b;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            margin-top: 10px;
        }
        .card button:hover {
            background-color: #004d40;
        }
        .back-button {
            position: absolute;
            top: 20px;
            left: 20px;
            font-size: 16px;
            color: white;
            background-color: transparent;
            text-decoration: none;
            padding: 10px;
            border-radius: 5px;
            transition: color 0.3s ease;
        }
        .back-button:hover {
            color: #004d40;
        }
    </style>
</head>
<body>

    <!-- Back to Home Link -->
    <a href="frontpage.jsp" class="back-button">Back to Home</a>

    <div class="card">
        <h2>Sign In</h2>
        <form action="login.jsp" method="get">
            <input type="text" id="username" name="username" placeholder="Name" required><br>
            <input type="email" id="email" name="email" placeholder="Email" required><br>
            <input type="password" id="password" name="password" placeholder="Password" required><br>
            <button type="submit">Sign In</button>
        </form>
    </div>

</body>
</html>
