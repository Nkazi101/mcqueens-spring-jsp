<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>

    <link rel="stylesheet" href="/css/signin.css"/>
</head>
<body>
    <!-- allows you to include the navbar on this page -->
    <jsp:include page="navbar.jsp"/>

   
    <div class ="signinpage">
     
    <!-- div is a container or a section -->
    <div class="signinbox">
      <h1>Sign In</h1>
    <form method ="post" action = "/signin">

        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input type="email" class="form-control" name="email" aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
          </div>
          <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input type="password" class="form-control" name="password">
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>

    </form>
  </div>
</div>

</body>
</html>