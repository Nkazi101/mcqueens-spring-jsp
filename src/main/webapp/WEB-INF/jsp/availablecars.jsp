<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Available Cars</title>

    <link rel="stylesheet" href="/css/availablecars.css"/>
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <h1>Available Cars</h1>

    <form action="/searchcar" method="get">
        <input type="text" name="model" placeholder="enter car model"/>
        <button type ="submit">Search</button>
    </form>

    <div class="carlist">
      

<c:forEach var="car" items="${cars}">
<a href="/cardetail/${car.id}">
<div class="caritems">

<img src="${car.photoUrl}"/>

<p>${car.manufacturerName} - ${car.model} - ${car.year}</p>

<!-- <button>Purchase</button> -->

</div>
</a>
</c:forEach>

    </div>



</body>
</html>