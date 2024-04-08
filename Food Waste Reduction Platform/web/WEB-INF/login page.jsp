<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Page</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #b1e09d; /* Pale green background */
      color: #333;
    }

    .container {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff; /* White background */
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      text-align: center;
      margin-top: 100px; /* Adjusted margin from the top */
    }

    form {
      display: flex;
      flex-direction: column;
      align-items: center;
    }

    label {
      display: block;
      text-align: left;
      margin-bottom: 5px;
      color: #000; /* Black color */
    }

    input[type="text"],
    input[type="password"] {
      width: 80%;
      padding: 10px;
      margin: 5px 0; /* Adjusted margin */
      border: 1px solid #397f46; /* Green border */
      border-radius: 3px;
      box-sizing: border-box;
    }

    input[type="submit"] {
      width: 50%;
      padding: 10px;
      background-color: #397f46; /* Green background */
      color: #fff; /* White text */
      border: none;
      border-radius: 3px;
      cursor: pointer;
      margin-top: 10px; /* Adjusted margin */
    }

    input[type="submit"]:hover {
      background-color: #306e3f; /* Darker green on hover */
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Login</h2>
    <form action="login.php" method="POST">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" placeholder="Enter your username" required>
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" placeholder="Enter your password" required>
      <input type="submit" value="Login">
    </form>
  </div>
</body>
</html>
