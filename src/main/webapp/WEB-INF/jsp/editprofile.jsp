<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <form method="post" action="/editprofile">

  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">First Name</label>
    <input type="text" class="form-control" name="firstName" aria-describedby="emailHelp" value="${buyerprofile.firstName}">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Last Name</label>
    <input type="text" class="form-control" name = "lastName" value="${buyerprofile.lastName}">
  </div> 
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Address</label>
    <input type="text" class="form-control" name="address" value="${buyerprofile.address}">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Phone Number</label>
    <input type="text" class="form-control" name="phoneNumber" value="${buyerprofile.phoneNumber}">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Email</label>
    <input type="text" class="form-control" name="email" value="${buyerprofile.email}">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" name="password" value="${buyerprofile.password}">
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</body>
</html>