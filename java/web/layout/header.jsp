    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%--
          Created by IntelliJ IDEA.
          User: shreya
          Date: 3/13/19
          Time: 11:17 AM
          To change this template use File | Settings | File Templates.
        --%>

    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
    <title>Title</title>
    </head>
    <body>
    <header>
    <nav class="navbar navbar-default">
    <div class="container-fluid">
    <ul class="nav navbar-nav">
    <li><a href="displayHero?pageRequest=list">Home</a></li>

    <c:if test="${sessionScope.user.role =='Admin'}">
        <li><a href="userList?pageRequest=userList">Users</a></li>
        <li><a href="createUser?pageRequest=createUser">Create User</a></li>

    </c:if>
    <li><a href="newHero?pageRequest=new">Add Super Hero</a></li>
    <li ></li>
    </ul>
    <h5  class="logout">Welcome, ${sessionScope.user.name}!
    <a href="logout?pageRequest=logout">Logout</a>
    </h5>
    </div>
    </nav>
    </header>


