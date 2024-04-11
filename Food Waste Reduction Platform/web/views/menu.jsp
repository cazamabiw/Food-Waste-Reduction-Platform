<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
    <link rel="stylesheet" href="../css/menu.css">
</head>
<body>
<nav class="menu">
<%
    String roleName = (String) session.getAttribute("roleName");
%>

<ul>
    <li style="color: white;">Welcome <%= roleName %></li>
    <li><a href="#">Home</a></li>
    <li><a href="inventory.jsp">Inventory</a></li>
    <% 
    if ("consumer".equals(roleName) || "charitable_organization".equals(roleName)){ %>
        <li><a href="usernotificationsetting.jsp">Notification Settings</a></li>
        <li><a href="usersettingfoodpreference.jsp">Food Preference</a></li>
    <% } %>
    <li><a href="report.jsp">Report</a></li>
    <li><a href="../LogoutServlet">Logout</a></li>
</ul>

</nav>
</body>
</html>
