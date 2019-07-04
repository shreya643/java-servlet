<%--
  Created by IntelliJ IDEA.
  User: shreya
  Date: 3/13/19
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/layout/header.jsp"%>



<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4 login-form">
        <h1>Create Super Hero</h1>
        <form  method="post" action="createHero?pageRequest=create">
            <input type="hidden" name="pageRequest" value="create">
            <div class="form-group row">
                <label class="col-sm-3">Super Hero Name:</label>
                <input type="text" name="name"  class="col-sm-7">
            </div>
            <div class="form-group row">
                <label class="col-sm-3">Power:</label>
                <input type="text" name="power" class="col-sm-7">
            </div>
            <div class="form-group row">
                <label class="col-sm-3">Universe:</label>
                <input type="text" name="universe" class="col-sm-7">
            </div>
            <div class="form-group row">
                <input type="submit" value="Create" class="col-sm-offset-4 col-sm-2 text-centre">
            </div>
        </form>
    </div>
</div>
</body>
</html>

