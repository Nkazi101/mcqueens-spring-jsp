<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <link rel="stylesheet" href="/css/profile.css"/>
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <div class="profilepage">

    <div class="profileinfo">

        <h1>User Profile</h1>

    <label>First Name</label>
    <p>${buyer.firstName}</p>
    <label>Last Name</label>
    <p>${buyer.lastName}</p>
    <label>Address</label>
    <p>${buyer.address}</p>
     <label>Email</label>
    <p>${buyer.email}</p>
    <label>Phone Number</label>
    <p>${buyer.phoneNumber}</p>

    <button><a href="/editprofile/${buyer.id}">Edit Profile</a></button>

    </div>

</div>
</body>
</html>