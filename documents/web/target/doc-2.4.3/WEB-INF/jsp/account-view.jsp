<%@ page import="it.academy.user.UserRoleUtil" %><%--
  Created by IntelliJ IDEA.
  User: Dina Maskalik
  Date: 12.05.2021
  Time: 02:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<table class="table">
    <thead>
    <tr>
        <td></td>
        <th scope="col">ID</th>
        <th scope="col">Логин</th>
        <th scope="col">Пароль</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${accountsList}" var="account">
        <tr>
            <td></td>
            <td>${account.id}</td>
            <td>${account.username}</td>
            <td>${account.password}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/doc/account" method="get">
    <div name="pageNumber">
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <c:forEach var="number" begin="1" end="${pageCount}">
                    <li class="page-item" tabindex="0">
                            <%--                <a class="page-link" href="/doc?pageNumber=${number}" name="pageNumber">--%>
                        <input class="btn btn-outline-success" type="submit" name="pageNumber" value="${number}">
                    </li>
                </c:forEach>
            </ul>
        </nav>
    </div>
    <%--    <button class="btn btn-outline-success" type="submit">Sort</button>--%>
</form>

<jsp:include page="footer.jsp"/>