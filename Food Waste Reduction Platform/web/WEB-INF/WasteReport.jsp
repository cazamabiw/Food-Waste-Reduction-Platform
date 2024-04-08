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
      background-color: #93C47D;
      color: #fff;
      border: none;
      padding: 10px 20px;
      cursor: pointer;
    }
    form input[type="submit"]:hover {
      background-color: #b6d7a8;
    }
    table {
      border-collapse: collapse;
      width: 100%;
      margin-top: 20px;
    }
    th, td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: left;
    }
    th {
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>
  <nav>
  <h1>Waste Report</h1>
    <ul>
      <li><a href="#home">Home</a></li>
      <li><a href="#inventory">Inventory</a></li>
      <li><a href="#account-settings">Account Settings</a></li>
    </ul>
  </nav>
    <div id="report">
    <form action="#" method="GET">
      <label for="month">Select Month:</label>
      <select id="month" name="month">
        <option value="January">January</option>
        <option value="February">February</option>
        <option value="March">March</option>
        <option value="April">April</option>
        <option value="May">May</option>
        <option value="June">June</option>
        <option value="July">July</option>
        <option value="August">August</option>
        <option value="September">September</option>
        <option value="October">October</option>
        <option value="November">November</option>
        <option value="December">December</option>
      </select>
      <input type="submit" value="Export Report">
    </form>
    <table>
      <thead>
        <tr>
          <th>Food Item</th>
          <th>Expiry Date</th>
          <th>Quantity</th>
        </tr>
      </thead>
      <tbody>
        <!-- Table data will be populated dynamically -->
      </tbody>
    </table>
  </div>
</body>
</html>
