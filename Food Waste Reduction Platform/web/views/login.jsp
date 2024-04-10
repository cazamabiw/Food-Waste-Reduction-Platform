<%-- 
    Document   : login
    Created on : Apr 10, 2024, 1:31:47 AM
    Author     : Pawinee Mahantamak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="../css/login.css">
</head>
<body>
    <div class="login-container">
        <h2>Login to Food Waste Reduction Platform</h2>
        <form action="../LoginServlet" method="post">
            <div class="input-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="input-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="btn">Login</button>
        </form>
         <%
        String errorMessage = request.getParameter("error");
        if (errorMessage != null && !errorMessage.isEmpty()) {
    %>
        <p style="color: red;"><%= errorMessage %></p>
    <%
        }
    %>
        <p>Don't have an account? <a href="registration.jsp">Register here</a></p>
    </div>
</body>
</html>
