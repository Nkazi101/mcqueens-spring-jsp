<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Car</title>
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <form method="post" action="/addcar"> 

        <label>Manufacturer Name</label> <br>
        <input type = "text" name = "manufacturerName" /> <br>
        <label>Model</label> <br>
        <input type="text" name="model" /> <br>
        <label>Year</label> <br>
        <input type="number" name="year"/> <br>
        <label>Date of Purchase</label> <br>
        <input type="date" name="dateofPurchase"/> <br>
        <label>VIN</label> <br>
        <input type="text" name="vin"/> <br>
        <label>Price</label> <br>
        <input type="number" name="price"/> <br>
        <label>Mileage</label> <br>
        <input type="number" name="mileage"/> <br>
        <label>Description</label> <br>
        <input type="text" name="description" /> <br>
        <label>Photo URL</label> <br>
        <input type="text" name="photoUrl"/> <br>

        <button type="submit">Submit</button>

    </form>



</body>
</html>
