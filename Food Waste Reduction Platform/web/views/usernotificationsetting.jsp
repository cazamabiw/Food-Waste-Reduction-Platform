<%@ page import="com.fwrp.models.UserNotificationSetting" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Retrieve notisetting object from the session
    UserNotificationSetting notisetting = (UserNotificationSetting) session.getAttribute("notisetting");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notification Setting</title>
    <link rel="stylesheet" href="../css/inventory.css">
    <link rel="stylesheet" type="text/css" href="../css/menu.css">
</head>
<body>
    <jsp:include page="menu.jsp" />
  
 
<div class="container">
    <h2>Notification Setting</h2>
    <form action="../SettingNotificationServlet" method="post" id="notificationForm">
        <div class="form-group">
            <input type="checkbox" id="isEmail" name="isEmail" <% if (notisetting != null && notisetting.isEmail()) { %>checked<% } %>>
            <label for="isEmail">Email</label>
        </div>
        <div class="form-group">
            <input type="checkbox" id="isSms" name="isSms" <% if (notisetting != null && notisetting.isPhone()) { %>checked<% } %>> <!-- Corrected from isPhone() to isSms() -->
            <label for="isSms">SMS</label>
        </div>
        <button type="submit">Save</button>
    </form>
</div>

    </div>
    <script>
        function toggleNotification() {
            var userNotifyCheckbox = document.getElementById('isUserNotify');
            var emailCheckbox = document.getElementById('isEmail');
            var smsCheckbox = document.getElementById('isSms');

         
        }
    </script>
</body>
</html>
