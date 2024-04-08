<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <style>
    /* Basic styling */
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }
    nav {
      background-color: #b1e09d;
      padding: 10px;
    }
    nav ul {
      list-style-type: none;
      padding: 0;
      margin: 0;
      text-align: right;
    }
    nav ul li {
      display: inline;
      margin-right: 20px;
    }
    nav ul li a {
      text-decoration: none;
      color: #333;
    }
    form {
      margin: 20px auto;
      max-width: 400px;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
    form input[type="text"],
    form input[type="number"],
    form input[type="date"] {
      width: 100%;
      margin-bottom: 10px;
      padding: 10px;
      box-sizing: border-box;
    }


form input[type="submit"] {
  background-color: #397f46;
  color: #fff;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
  margin-top: 10px; 
  width : 400px;
    form input[type="submit"]:hover {
      background-color: #b1e09d;
    } }
  </style>
</head>
<body>
  <nav>
  <h1>Add Food Item</h1>
    <ul>
      <li><a href="#home">Home</a></li>
      <li><a href="#inventory">Inventory</a></li>
      <li><a href="#account-settings">Account Settings</a></li>
    </ul>
  </nav>
  <div id="add-item-form">
    <form action="#" method="POST">
      <label for="item-name">Item Name</label>
      <input type="text" id="item-name" name="item-name" required placeholder="Enter item name"><br>
      <label for="quantity">Quantity</label>
      <input type="number" id="quantity" name="quantity" required placeholder="Enter quantity"><br>
      <label for="expiry-date">Expiry Date</label>
      <input type="date" id="expiry-date" name="expiry-date" required placeholder="Select expiry date"><br>
      <label for="price">Price</label>
      <input type="number" id="price" name="price" required placeholder="Enter price"><br>
      <input type="submit" value="Submit">
    </form>
  </div>
</body>
</html>
