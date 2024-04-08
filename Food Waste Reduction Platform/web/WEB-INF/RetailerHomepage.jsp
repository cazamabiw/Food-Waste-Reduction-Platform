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
  </style>
</head>
<body>
  <nav>
  <h1>Welcome, User</h1>
    <ul>
      <li><a href="#home">Home</a></li>
      <li><a href="#inventory">Inventory</a></li>
      <li><a href="#account-settings">Account Settings</a></li>
    </ul>
  </nav>
  <div id="home">
    <h2>There are xx food items on surplus today!</h2>
    <h2>Go to inventory to decide what to do with them.</h2>
  </div>
</body>
</html>
