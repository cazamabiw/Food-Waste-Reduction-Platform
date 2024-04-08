<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Create Account</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #b1e09d;
      color: #333;
    }

    .container {
      max-width: 800px;
      margin: 0 auto;
      margin-top:165px;
      padding: 20px;
    }

    form {
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    label {
      display: inline-block;
      /* flex: 0 0 40%;  */
      width: 150px;
      margin-bottom: 5px;
    }

    /* label {
  flex: 0 0 40%; /* Adjusted width for labels */
  /* margin-bottom: 5px;
} */ 

input[type="text"],
input[type="email"],
input[type="password"],
select {
  width: calc(50% - 180px);
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #558a5f;
  border-radius: 3px;
  box-sizing: border-box;
  display: inline-block;
  vertical-align: middle;
  /* Increase the height and font size */
  height: 40px;
  font-size: 16px;
}

    input[type="submit"] {
      background-color: #397f46;
      color: #fff;
      border: none;
      padding: 10px 20px;
      cursor: pointer;
      display: block;
      margin-top: 10px;
      margin-left: 150px;
    }

    input[type="submit"]:hover {
      background-color: #306e3f;
    }

    
  </style>
</head>
<body>
  <div class="container">
    <form action="process_account.php" method="POST">
      <label for="first_name">First Name</label>
      <input type="text" id="first_name" name="first_name" required>
      <label for="last_name" style="/* margin-left: 18px; */">Last Name</label>
      <input type="text" id="last_name" name="last_name" required><br>
      <label for="email">Email</label>
      <input type="email" id="email" name="email" required>
      <label for="pass">Password</label>
      <input type="password" id="pass" name="pass" required><br>
      <label for="address_line">Address Line</label>
      <input type="text" id="address_line" name="address_line">
      <label for="city">City</label>
      <input type="text" id="city" name="city"><br>
      <label for="province">Province</label>
      <input type="text" id="province" name="province">
      <label for="postal_code">Postal Code</label>
      <input type="text" id="postal_code" name="postal_code"><br>
      <label for="roles">Role</label>
      <select id="roles" name="roles">
        <option value="consumer">Consumer</option>
        <option value="retailer">Retailer</option>
        <option value="charitable">Charitable Role</option>
      </select><br>
      <a href="login page"> <input type="submit" value="Create Account"></a>
    </form>
  </div>
</body>
</html>
