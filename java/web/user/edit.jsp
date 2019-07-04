<%--
  Created by IntelliJ IDEA.
  User: shreya
  Date: 2/7/19
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/layout/header.jsp"%>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4 login-form">
        <h1>Edit User</h1>
        <form  method="post" action="editUser" >
            <input type="hidden" name="pageRequest" value="edit">
            <div class="form-group row">
                <label class="col-sm-3">Name:</label>
                <input type="text" name="username" placeholder="username" class="col-sm-7" value="${user.name}">
            </div>
            <div class="form-group row">
                <label class="col-sm-3">Password:</label>
                <input type="password" name="password" placeholder="password" class="col-sm-7" value="${user.password}">
            </div>
            <div class="form-group row">
                <label class="col-sm-3">Role:</label>
                <input type="text" name="role" placeholder="role" class="col-sm-7" value="${user.role}">
            </div>
            <input type="hidden" name="id"  class="col-sm-7" value="${user.id}">
            <div class="form-group row">
                <input type="submit" value="Edit" class="col-sm-offset-4 col-sm-2 text-centre">
            </div>
        </form>
    </div>
</div>
</body>
</html>
