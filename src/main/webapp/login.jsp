<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/31/2023
  Time: 8:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>

</head>
<body>
<!-- thêm message-->
<h1 style="text-align: center" > Login</h1>
<form class="container" style="width: 400px" method="post" action="accounts?action=login">
    <!-- Email input -->
    <div class="form-outline mb-4">
        <input type="text" id="form2Example1" name="username" class="form-control" placeholder="Enter Name" required/>
        <label class="form-label" for="form2Example1"  >UserName</label>
    </div>

    <!-- Password input -->
    <div class="form-outline mb-4">
        <input type="password" id="form2Example2" name="password" class="form-control" placeholder=" Enter Password" required/>
        <label class="form-label" for="form2Example2">Password</label>
    </div>

    <!-- 2 column grid layout for inline styling -->
    <div class="row mb-4">
        <div class="col d-flex justify-content-center">
            <!-- Checkbox -->
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked required />
                <label class="form-check-label" for="form2Example31"> Remember me </label>
            </div>
        </div>

        <div class="col">
            <!-- Simple link -->
            <a href="#!">Forgot password?</a>
        </div>
    </div>

    <!-- Submit button -->
    <button  type="submit" class="btn btn-primary btn-block mb-4" style="width: 380px; text-align: center; margin: 0 auto;">Sign in</button>
    <!-- Register buttons -->
    <div class="text-center">
        <p>Not a member? <a href="accounts?action=register">Register</a></p>
        <p>or sign up with:</p>
        <button type="button" class="btn btn-link btn-floating mx-1">
            <i class="fab fa-facebook-f"></i>
        </button>

        <button type="button" class="btn btn-link btn-floating mx-1">
            <i class="fab fa-google"></i>
        </button>

        <button type="button" class="btn btn-link btn-floating mx-1">
            <i class="fab fa-twitter"></i>
        </button>

        <button type="button" class="btn btn-link btn-floating mx-1">
            <i class="fab fa-github"></i>
        </button>
    </div>
</form>
</body>
</html>
