<%--
  Created by IntelliJ IDEA.
  User: shreya
  Date: 1/3/19
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body id="login">
  <div class="row" >
    <div class="col-md-4"></div>
    <div class="col-md-4 login-form">
      <h1 class="text-centre">Login</h1>
      <form  method="post" action="loginForm">
        <input type="hidden" name="pageRequest" value="login">
        <div class="form-group row">
          <label class="col-sm-3">Name:</label>
          <input type="text" name="username" placeholder="username" class="col-sm-7">
        </div>
        <div class="form-group row">
          <label class="col-sm-3">Password:</label>
          <input type="password" name="password" placeholder="password" class="col-sm-7">
        </div>
        <div class="form-group row">
          <input type="submit" value="Login" class="col-sm-offset-4 col-sm-2 text-centre btn">
        </div>
      </form>
    </div>
   </div>
  </body>
</html>
