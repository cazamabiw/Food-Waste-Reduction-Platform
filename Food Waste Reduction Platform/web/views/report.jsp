<%@page import="com.fwrp.datatier.dto.InventorySummaryReportDTO"%>
<%@ page import="com.fwrp.models.UserNotificationSetting" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Retrieve notisetting object from the session
    InventorySummaryReportDTO report = (InventorySummaryReportDTO) session.getAttribute("reportCurrentMonthly");
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

     <div class="form-group">
           Start Date: <label id="startDate" name="startDate"><%= report.getStartDate() %></label><br>
           End Date: <label id="endDate" name="endDate"><%= report.getEndDate() %></label><br>
           Minimize Food Waste Total: <label id="minimizeFoodWasteTotal" name="minimizeFoodWasteTotal"><%= report.getFoodNameCommon() %></label><br>
           Common Food Item: <label id="commonFoodItem" name="commonFoodItem"><%= report.getFoodNameCommon() %></label><br>
           Common Food Item Quantity: <label id="commonFoodItemQuantity" name="commonFoodItemQuantity"><%= report.getFoodNameCommonQuantity() %></label><br>
           Uncommon Food Item: <label id="uncommonFoodItem" name="uncommonFoodItem"><%= report.getFoodNameUnCommon() %></label><br>
           Uncommon Food Item Quantity: <label id="uncommonFoodItemQuantity" name="uncommonFoodItemQuantity"><%= report.getFoodNameUnCommonQuantity() %></label><br>
        </div>
</div>
</body>
</html>
