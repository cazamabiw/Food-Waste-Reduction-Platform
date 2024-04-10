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
        <title>Inventory</title>
        <link rel="stylesheet" href="../css/inventory.css"><head>

    <link rel="stylesheet" type="text/css" href="..css/menu.css">
    </head>
    <body>
         <jsp:include page="menu.jsp" />
        <div class="container">
            <h2>Inventory</h2>

            <% String roleName = (String) session.getAttribute("roleName");
            if ("retailer".equals(roleName)) { %>
            <button id="addItemBtn">Add Item</button>
            <div class="popup" id="addItemPopup">
                <div class="popup-content">
                    <span class="close-btn" id="closePopupBtn">&times;</span>
                    <h3>Add New Item</h3>

                    <form action="../AddItemServlet" method="post">
          
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
                        </div>
                        <div class="form-group">
                            <label for="quantity">Quantity:</label>
                            <input type="number" id="quantity" name="quantity" placeholder="Enter quantity" required>
                        </div>
                        <div class="form-group">
                            <label for="price">Price:</label>
                            <input type="number" id="price" name="price" placeholder="Enter price" required>
                        </div>
                      <div class="form-group">
    <label for="foodStatus">Food Status:</label>
    <select id="foodStatusId" name="foodStatusId" required>
        <% 
        List<FoodStatus> foodStatuses = (List<FoodStatus>) session.getAttribute("foodStatuses");
        if (foodStatuses != null && !foodStatuses.isEmpty()) {
            for (FoodStatus status : foodStatuses) {
        %>
        <option value="<%= status.getFoodStatusId() %>"><%= status.getFoodStatus() %></option>
        <% 
            }
        }
        %>
    </select>
</div>

                        <div class="form-group">
                            <label for="expirationDate">Expiration Date:</label>
                            <input type="date" id="expirationDate" name="expirationDate" required>
                        </div>
                        <button type="submit">Save</button>
                    </form>
                </div>
            </div>



            <table>
                <thead>
                    <tr>
                        <th>Item Id</th>
                        <th>Item Name</th>
                        <th>Food Status</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Discount price</th>
                        <th>Expiration Date</th>
                        <th>Surplus</th>
                        <th>For</th>
                        <th>Update</th>

                    </tr>
                </thead>
                <tbody>
                    <% List<InventoryResult> inventory = (List<InventoryResult>) session.getAttribute("inventory");
                        if (inventory != null && !inventory.isEmpty()) {
                            for (InventoryResult item : inventory) {%>
              <tr>
                  <td class="itemId"><%= item.getId()%></td>
    <td class="foodName"><%= item.getFoodName()%></td>
    <td class="foodStatus"><%= item.getFoodStatus()%></td>
    <td class="quantity"><%= item.getQuantity()%></td>
    <td class="price"><%= item.getPrice()%></td>
    <td class="discountedPrice"><%= item.getDiscountedPrice()%></td>
    <td class="expirationDate"><%= item.getExpirationDate()%></td>
    <td class="isSurplus"><%= item.isSurplus()%></td>
<td>
    <% 
    if (!item.isSurplus()) {
        out.println("-");
    } else if (item.isSurplus() && item.getDiscountedPrice() > 0.0) {
        out.println("For Sale");
    } else if (item.isSurplus() && item.getDiscountedPrice() == 0.0) {
        out.println("For Donation");
    }
    %>
</td>
    <td><button class="updateBtn">Update</button></td>
</tr>
                    <%     }
                    } else { %>
                    <tr>
                        <td colspan="9" class="no-items">No items in inventory</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
<div class="popup" id="updateItemPopup">
    <div class="popup-content">
        <span class="close-btn" id="closeUpdatePopupBtn">&times;</span>
        <h3>Update Item</h3>
        <form id="updateItemForm" action="../UpdateItemServlet" method="post">
            <!-- Form fields -->
            <input type="hidden" id="updateItemId" name="itemId">
            <div class="form-group">
                <label for="updateFoodName">Food Name:</label>
                <label id="updateFoodNameLabel" name="foodName"></label>
            </div>
            <div class="form-group">
                <label for="updateFoodStatus">Food Status:</label>
                <select id="updateFoodStatus" name="foodStatus" required>
               <% 
    //List<FoodStatus> foodStatusesUpdate = (List<FoodStatus>) session.getAttribute("foodStatuses");
    if (foodStatuses != null && !foodStatuses.isEmpty()) {
        for (FoodStatus status : foodStatuses) {
%>
<option value="<%= status.getFoodStatusId() %>"><%= status.getFoodStatus() %></option>
<% 
        }
    }
%>
                </select>
            </div>
            <div class="form-group">
                <label for="updateQuantity">Quantity:</label>
                <input type="number" id="updateQuantity" name="quantity" required>
            </div>
            <div class="form-group">
                <label for="updatePrice">Price:</label>
                <input type="number" id="updatePrice" name="price" required>
            </div>
            <div class="form-group">
                <label for="updateDiscountedPrice">Discounted Price:</label>
                <input type="number" id="updateDiscountedPrice" name="discountedPrice" required>
            </div>
            <div class="form-group">
                <label for="updateExpirationDate">Expiration Date:</label>
                <input type="date" id="updateExpirationDate" name="expirationDate" required>
            </div>
            <div class="form-group">
                <label for="updateIsSurplus">Surplus:</label>
                <input type="checkbox" id="updateIsSurplus" name="isSurplus">
            </div>
            <button class="updateBtn">Update</button>
        </form>
    </div>
</div>
<script>
// Add event listener to each update button
document.querySelectorAll('table .updateBtn').forEach(button => {
    button.addEventListener('click', function() {
        // Get the corresponding row of the clicked button
        const row = this.closest('tr');
        // Extract data from the row
        const itemId = row.querySelector('.itemId').textContent;
        const foodName = row.querySelector('.foodName').textContent;
        const foodStatus = row.querySelector('.foodStatus').textContent; // Assuming foodStatus contains the value you want to use
        const quantity = row.querySelector('.quantity').textContent;
        const price = row.querySelector('.price').textContent;
        const discountedPrice = row.querySelector('.discountedPrice').textContent;
        const expirationDate = row.querySelector('.expirationDate').textContent;
        const isSurplus = row.querySelector('.isSurplus').textContent;
        // Populate the form fields in the pop-up with the extracted data
        document.getElementById('updateItemId').value = itemId;
        document.getElementById('updateFoodNameLabel').textContent = foodName;
        // Set the selected option based on foodStatus
        const updateFoodStatusSelect = document.getElementById('updateFoodStatus');
        for (let option of updateFoodStatusSelect.options) {
            if (option.text === foodStatus) {
                option.selected = true;
                break;
            }
        }
        document.getElementById('updateQuantity').value = quantity;
        document.getElementById('updatePrice').value = price;
        document.getElementById('updateDiscountedPrice').value = discountedPrice;
        document.getElementById('updateExpirationDate').value = expirationDate;
        document.getElementById('updateIsSurplus').checked = (isSurplus === 'true');
        // Show the update pop-up
        document.getElementById('updateItemPopup').style.display = 'block';
    });
});

// Close update pop-up when close button is clicked
document.getElementById('closeUpdatePopupBtn').addEventListener('click', function() {
    document.getElementById('updateItemPopup').style.display = 'none';
});

</script>


  <script>
                // Function to display the popup when the button is clicked
                document.getElementById("addItemBtn").addEventListener("click", function () {
                    document.getElementById("addItemPopup").style.display = "block";
                });
                document.getElementById("closePopupBtn").addEventListener("click", function () {
                    document.getElementById("addItemPopup").style.display = "none";
                });
            </script>
            <% } else if ("consumer".equals(roleName) || "charitable_organization".equals(roleName)) { %>
            <table>
                <thead>
                    <tr>
                        <th>Item Name</th>
                        <th>Food Status</th>
                        <th>Quantity</th>
                            <% if ("consumer".equals(roleName)) { %>
                        <th>Price</th>
                        <th>Discount price</th>
                            <% } %>
                        <th>Expiration Date</th>
                        <th>Surplus</th>
                            <% if ("consumer".equals(roleName)) { %>
                        <th>Claim</th>
                            <% } else if ("charitable_organization".equals(roleName)) { %>
                        <th>Purchase</th>
                            <% } %>
                    </tr>
                </thead>
                <tbody>
                    <% List<InventoryResult> inventory = (List<InventoryResult>) session.getAttribute("inventory");
                        if (inventory != null && !inventory.isEmpty()) {
                            for (InventoryResult item : inventory) {%>
                    <tr>
                        <td><%= item.getFoodName()%></td>
                        <td><%= item.getFoodStatus()%></td>
                        <td><%= item.getQuantity()%></td>
                        <% if ("consumer".equals(roleName)) {%>
                        <td><%= item.getPrice()%></td>
                        <td><%= item.getDiscountedPrice()%></td>
                        <% }%>
                        <td><%= item.getExpirationDate()%></td>
                        <td><%= item.isSurplus()%></td>
                        <% if ("consumer".equals(roleName)) { %>
                        <td><button>Claim</button></td>
                        <% } else if ("charitable_organization".equals(roleName)) { %>
                        <td><button>Purchase</button></td>
                        <% } %>
                    </tr>
                    <%     }
                    } else { %>
                    <tr>
                        <td colspan="7" class="no-items">No items in inventory</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <% }%>
        </div>
    </body>
</html>
