<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="/css/cart.css"/>
    
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <div class="cartpage">

     <h1>Your Shopping Cart</h1>

    <c:forEach var="item" items="${cartItems}">

    <div class = "cartitem">
    <img src = "${item.photoUrl}" />
    <p>${item.manufacturerName}</p>
    <p>${item.model}</p>
    <p>${item.price}</p>
    <button><a href = "/cart/remove/${item.id}">Remove</a></button>
</div>

    </c:forEach>

    <a href="/create-session">Proceed to checkout</a>

</div>

</body>
</html>