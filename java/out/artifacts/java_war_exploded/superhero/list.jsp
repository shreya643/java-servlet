<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  hero: shreya
  Date: 1/31/19
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/layout/header.jsp"%>
<div class="row">
    <h1 class="col-md-offset-2 col-md-8"> Superhero List</h1>
    <table class="table-striped table-list col-md-offset-2 col-md-8">
        <tr class="row">
            <td class="col-sm-1">Sno</td>
            <td class="col-sm-3">Name</td>
            <td class="col-sm-3">Universe</td>
            <td class="col-sm-3">Powers</td>
            <td class="col-sm-2">Action</td>
        </tr>
        <c:forEach items="${superHeroList}" var="hero" varStatus="theCount">
            <tr class="row">
                <td class="col-sm-1">${theCount.count}</td>
                <td class="col-sm-3">${hero.name}</td>
                <td class="col-sm-3">${hero.universe}</td>
                <td class="col-sm-3">${hero.powers}</td>
                <td class="col-sm-2"><a href="editHero?pageRequest=edit&id=${hero.id}">Edit</a>/<a href="deleteHero?pageRequest=delete&id=${hero.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
