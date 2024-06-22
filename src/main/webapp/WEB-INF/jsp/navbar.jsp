<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="/css/navbar.css"/>
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
          <a class="navbar-brand" href="/">McQueens</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="/cars">Cars</a>
              </li>


              <c:if test="${empty sessionScope.user}">

              <li class="nav-item">
                <a class="nav-link" href="/signin">Sign In</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/signup">Sign Up</a>
              </li>

            </c:if>

            <!-- sessionScope is a way to access attributes that are stored in the 'HttpSession' object -->
            <c:choose>

            <c:when test="${sessionScope.userType == 'Buyer'}">


            <li class="nav-item">
              <a class="nav-link" href="/profile">Profile</a>
            </li>
            <div class="carticon">
              <li class="nav-item">
                <i class="fa-solid fa-cart-shopping"><a class="nav-link" href="/cart"></a></i>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
              </li>

            </c:when>

            <c:when test="${sessionScope.userType == 'Seller'}" >

            <li class="nav-item">
              <a class="nav-link" href="/addcar">Add Car</a>
            </li>

            <li class="nav-item">
              <a class="nav-link" href="/logout">Logout</a>
            </li>

            </c:when>


            </c:choose>

            
              </div>
            </ul>
          </div>
        </div>
      </nav>
</body>
</html>

