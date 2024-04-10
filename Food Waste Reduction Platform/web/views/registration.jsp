<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Registration</title>
 <link rel="stylesheet" type="text/css" href="../css/register.css">
<style>


#storeFields,
#consumerFields,
#charitableFields {
    display: none;
}
</style>
</head>
<body>
<div class="register-container">
    <h2>User Registration</h2>
  
     <form action="../RegisterServlet" method="post">

    <div class="input-group">
        <label for="userType">User Type:</label>
      <select id="userType" name="userType" onchange="showFields()">
            <option value="retailer">Retailer</option>
            <option value="consumer">Consumer</option>
            <option value="charitable">Charitable Organization</option>
        </select>
    </div>
    <div class="input-group">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required>
    </div>
    <div class="input-group">
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required>
    </div>
    <div class="input-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
    </div>
    <div class="input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div class="input-group">
        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone" required>
    </div>
    <div class="input-group" id="storeFields">
        <label for="storeName">Store Name:</label>
        <input type="text" id="storeName" name="storeName">
    </div>
    <div class="input-group" id="contactFields">
        <label for="contactPerson">Contact Person:</label>
        <input type="text" id="contactPerson" name="contactPerson">
    </div>
    <div class="input-group" id="consumerFields">
        <label for="shippingAddress">Shipping Address:</label>
        <input type="text" id="shippingAddress" name="shippingAddress">
    </div>
    <div class="input-group" id="paymentFields">
        <label for="paymentMethod">Payment Method:</label>
        <input type="text" id="paymentMethod" name="paymentMethod">
    </div>
    <div class="input-group" id="charitableFields">
        <label for="organizationName">Organization Name:</label>
        <input type="text" id="organizationName" name="organizationName">
    </div>
    <div class="input-group">
        <label for="city">City:</label>
        <input type="text" id="city" name="city" required>
    </div>
    <div class="input-group">
        <label for="province">Province:</label>
        <input type="text" id="province" name="province" required>
    </div>
    <div class="input-group">
        <label for="postalCode">Postal Code:</label>
        <input type="text" id="postalCode" name="postalCode" required>
    </div>
    </form>
    <button type="submit" class="btn">Register</button>
     </form>
       <p>Already have an account? <a href="login.jsp">Login here</a></p>
</div>

<script>
function showFields() {
    var userType = document.getElementById("userType").value;
    var storeFields = document.getElementById("storeFields");
    var contactFields = document.getElementById("contactFields");
    var consumerFields = document.getElementById("consumerFields");
    var paymentFields = document.getElementById("paymentFields");
    var charitableFields = document.getElementById("charitableFields");

    // Hide all fields first
    storeFields.style.display = "none";
    contactFields.style.display = "none";
    consumerFields.style.display = "none";
    paymentFields.style.display = "none";
    charitableFields.style.display = "none";

    // Show fields based on selected user type
    if (userType === "retailer") {
        storeFields.style.display = "block";
        contactFields.style.display = "block";
    } else if (userType === "consumer") {
        consumerFields.style.display = "block";
        paymentFields.style.display = "block";
    } else if (userType === "charitable") {
        charitableFields.style.display = "block";
    }
}

function showMessage() {
    var registrationSuccess = '${registrationSuccess}';
    if (registrationSuccess) {
        alert('Registration successful! You can now login.');
        console.log('${registrationSuccess}');
    }
}

document.addEventListener('DOMContentLoaded', function() {
    showMessage();
});

</script>
</body>
</html>
