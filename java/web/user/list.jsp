<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shreya
  Date: 2/7/19
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/layout/header.jsp"%>
<div class="row">
    <h1 class="col-md-offset-2 col-md-8">User List</h1>
<table class="table-striped col-md-offset-2 col-md-8">
    <tr class="row">
        <td class="col-sm-1">Sno</td>
        <td class="col-sm-4">Name</td>
        <td class="col-sm-4">Role</td>
        <td class="col-sm-3">Action</td>

    </tr>
    <c:forEach items="${userList}" var="user" varStatus="theCount">
        <tr class="row">
            <td class="col-sm-1">${theCount.count}</td>
            <td class="col-sm-4">${user.name}</td>
            <td class="col-sm-4">${user.role}</td>
            <td class="col-sm-3"><a href="createUser?pageRequest=editUser&name=${user.name}&password=${user.password}">Edit</a>
           /<a href="deleteUser?pageRequest=deleteUser&id=${user.id}">Delete</a></td>
        </tr>

    </c:forEach>
</table>
</div>
</body>
</html>
