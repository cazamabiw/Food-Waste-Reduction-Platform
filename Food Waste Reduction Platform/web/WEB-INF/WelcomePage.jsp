<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Welcome Page</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #fff; /* White background */
      color: #333;
    }

    .container {
      max-width: 800px;
      margin: 0 auto;
      padding: 20px;
    }

    nav {
      background-color: #b1e09d; /* Pale green background */
      padding: 20px; /* Increased padding */
      text-align: right;
    }

    nav a {
      text-decoration: none;
      color: #333;
      margin-left: 20px;
      transition: color 0.3s; /* Smooth transition on color change */
      font-size: 18px; /* Increased font size */
    }

    nav a:hover {
      color: #124e21; /* Darker green on hover */
    }

    .content {
      margin-top: 20px; /* Adjusted margin-top */
      text-align: left; /* Align text to the left */
    }

    .content img {
      float: left; /* Float the image to the left */
      margin-right: 30px; /* Add space between image and text */
      width: 300px; /* Set the width of the image */
      height: auto; /* Maintain aspect ratio */
    }

    .content h2 {
      color: #397f46; /* Darker green for heading */
      font-size: 32px; /* Increased font size */
      margin-bottom: 20px; /* Added margin below heading */
    }

    .content p {
      margin-bottom: 15px; /* Added margin below each paragraph */
      font-size: 20px; /* Increased font size */
    }

    .content a:hover {
      color: #124e21; /* Darker green on hover */
    }

  </style>
</head>
<body>
  <nav>
    <a href="login page">Login</a>
  </nav>
  <div class="container">
    <div class="content">
 
      <h2>Food Waste Reduction Platform</h2>
      <p>Welcome to our platform dedicated to reducing food waste and promoting sustainability.</p>
      <p>Food waste is a significant global issue, with millions of tons of food being wasted each year, while millions of people around the world suffer from hunger.</p>
      <p>By joining our platform, you can contribute to reducing food waste by managing your food inventory efficiently, sharing surplus food with others, and promoting sustainable practices.</p>
      <p>New User? <a href="CreateAccount.html" style="text-decoration:none; color:#397f46;">Create Account</a></p>
    </div>
  </div>
</body>
</html>
