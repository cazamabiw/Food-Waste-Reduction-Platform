<%@page import="com.fwrp.models.FoodItem"%>
<%@page import="com.fwrp.datatier.dto.UserFoodPreferenceDTO"%>
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
        <button id="addItemBtn">Add Item</button>
        <table>
            <thead>
                <tr>
                    <th>Food Id</th>
                    <th>Food Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<UserFoodPreferenceDTO> foodPrefs = (List<UserFoodPreferenceDTO>) session.getAttribute("userfoodPref");
                    if (foodPrefs != null && !foodPrefs.isEmpty()) {
                        for (UserFoodPreferenceDTO item : foodPrefs) {
                %>
                <tr>
                    <td class="fooId"><%= item.getFoodItemId() %></td>
                    <td class="foodName"><%= item.getFoodName() %></td>
                    <td>
                        <!-- Add your action button here -->
                        <button>Delete</button>
                    </td>
                </tr>
                <% 
                        }
                    } else { 
                %>
                <tr>
                    <td colspan="3">No food preferences available</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
            <div class="popup" id="addItemPopup">
                <div class="popup-content">
                    <span class="close-btn" id="closePopupBtn">&times;</span>
                    <h3>Add Food Preference Item</h3>

                    <form action="../AddFoodPrefServlet" method="post">
          
                        <div class="form-group">
                         <select id ="foodItemId"name="foodItemId">
    <% List<FoodItem> foodItems = (List<FoodItem>) session.getAttribute("foodItems");
       if (foodItems != null && !foodItems.isEmpty()) {
           for (FoodItem item : foodItems) { %>
               <option value="<%= item.getFoodItemId() %>"><%= item.getItemName() %></option>
    <%    }
       }
    %>
</select>
<br> <br>

                        <button type="submit">Save</button>
                    </form>
                </div>
            </div>
          <script>
    // Function to display the popup when the button is clicked
    document.getElementById("addItemBtn").addEventListener("click", function () {
        document.getElementById("addItemPopup").style.display = "block";
    });
    document.getElementById("closePopupBtn").addEventListener("click", function () {
        document.getElementById("addItemPopup").style.display = "none";
    });
</script>
            
</body>
</html>
