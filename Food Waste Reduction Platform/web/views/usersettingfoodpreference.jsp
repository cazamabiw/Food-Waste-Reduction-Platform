<%@page import="com.fwrp.models.FoodStatus"%>
<%@page import="com.fwrp.models.FoodItem"%>
<%@page import="com.fwrp.utilities.InventoryResult"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Preferences</title>
    <link rel="stylesheet" href="../css/inventory.css">
    <link rel="stylesheet" href="../css/menu.css">
</head>
<body>
    <jsp:include page="menu.jsp" />
    <div class="container">
        <h2>Food Preferences</h2>
        <button id="addFoodBtn">Add</button>
        <table>
            <thead>
                <tr>
                  
                    <th>Food Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody id="foodPreferenceTable">
                <!-- Table rows will be dynamically added here -->
      
            <td>  </td>
            <td> <button>Delete</button> </td>
            </tbody>
        </table>
    </div>
</body>
</html>
