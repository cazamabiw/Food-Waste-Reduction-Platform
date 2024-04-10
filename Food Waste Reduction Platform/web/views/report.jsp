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
    <h2>Report</h2>
    <form action="../ReportServlet" method="post" id="reportfrom">
        <button type="submit">Generate report current month</button>
        
         </form>
      <form action="../HistoryReportServlet" method="post" id="reportfromw">
        <button type="submit">Generate history report current month</button>
    </form>
</div>

    </div>

</body>
</html>
