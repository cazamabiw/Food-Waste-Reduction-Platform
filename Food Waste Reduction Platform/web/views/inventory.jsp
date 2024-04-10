<%@page import="com.fwrp.utilities.InventoryResult"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory</title>
      <link rel="stylesheet" href="../css/inventory.css">
</head>
<body>
    <div class="container">
        <h2>Inventory</h2>

        <% String roleName = (String) session.getAttribute("roleName");
           if ("retailer".equals(roleName)) { %>
      <button id="addItemBtn">Add Item</button>
     <div class="popup" id="addItemPopup">
            <div class="popup-content">
                <span class="close-btn" id="closePopupBtn">&times;</span>
                <h3>Add New Item</h3>
                <form id="addItemForm" action="AddItemServlet" method="post">
                    <div class="form-group">
                        <label for="itemName">Food Item Name:</label>
                        <input type="text" id="itemName" name="itemName" placeholder="Enter food item name" required>
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
                        <select id="foodStatus" name="foodStatus" required>
                            <option value="Fresh">Fresh</option>
                            <option value="Expired">Expired</option>
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
                        <th>Item Name</th>
                        <th>Food Status</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Discount price</th>
                        <th>Expiration Date</th>
                        <th>Surplus</th>
                        <th>Update</th>
                      
                    </tr>
                </thead>
                <tbody>
                    <% List<InventoryResult> inventory = (List<InventoryResult>) session.getAttribute("inventory");
                       if (inventory != null && !inventory.isEmpty()) {
                           for (InventoryResult item : inventory) { %>
                               <tr>
                                   <td><%= item.getFoodName()%></td>
                                   <td><%= item.getFoodStatus()%></td>
                                   <td><%= item.getQuantity()%></td>
                                   <td><%= item.getPrice()%></td>
                                   <td><%= item.getDiscountedPrice()%></td>
                                   <td><%= item.getExpirationDate()%></td>
                                   <td><%= item.isSurplus()%></td>
                                   <td><button>Update</button></td>
                    
                               </tr>
                    <%     }
                       } else { %>
                           <tr>
                               <td colspan="9" class="no-items">No items in inventory</td>
                           </tr>
                    <% } %>
                </tbody>
            </table>
                  <script>
        // Function to display the popup when the button is clicked
        document.getElementById("addItemBtn").addEventListener("click", function() {
            document.getElementById("addItemPopup").style.display = "block";
        });
        document.getElementById("closePopupBtn").addEventListener("click", function() {
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
                           for (InventoryResult item : inventory) { %>
                               <tr>
                                   <td><%= item.getFoodName()%></td>
                                   <td><%= item.getFoodStatus()%></td>
                                   <td><%= item.getQuantity()%></td>
                                   <% if ("consumer".equals(roleName)) { %>
                                       <td><%= item.getPrice()%></td>
                                       <td><%= item.getDiscountedPrice()%></td>
                                   <% } %>
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
        <% } %>
    </div>
</body>
</html>
