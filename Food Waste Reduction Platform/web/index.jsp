<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.fwrp.datatier.controller.UserController" %>
<%
    // Get the current session
   // HttpSession session = request.getSession(false);

    // Check if the session exists and contains a user object
//    if (session != null && session.getAttribute("currentUser") != null) {
//        // Session exists and user is logged in, redirect to inventory page
//        response.sendRedirect("views/inventory.jsp");
//    } else {
//        // Session does not exist or user is not logged in, display the index page
//       
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Food Waste Reduction Platform</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <style>
        /* Additional CSS for improved layout and button styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 60%;
            margin: 100px auto;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 40px;
            text-align: center;
        }
        header h1 {
            font-size: 32px;
            margin-bottom: 20px;
        }
        header p {
            font-size: 18px;
            color: #666;
            margin-bottom: 40px;
        }
        .image-container {
            margin-bottom: 40px;
        }
        .buttons {
            display: flex;
            justify-content: center;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            border-radius: 5px;
            transition: background-color 0.3s;
            margin: 0 10px;
        }
        .button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <header>
            <h1>Welcome to the Food Waste Reduction Platform</h1>
            <p>A comprehensive solution to reduce food waste and promote sustainability.</p>
        </header>
        
        <div class="image-container">
            <img src="images/food-waste-image.png" alt="Food Waste Image" width="400">
        </div>
        
        <div class="buttons">
            <a href="views/registration.jsp" class="button">Register</a>
            <a href="views/login.jsp" class="button">Login</a>
        </div>
    </div>
</body>
</html>
<%
  //  }
%>