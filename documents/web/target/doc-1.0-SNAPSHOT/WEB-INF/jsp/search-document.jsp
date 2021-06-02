<%--
  Created by IntelliJ IDEA.
  User: Dina Maskalik
  Date: 16.03.2021
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>

<form action="/doc/document/search" method="post">
    <%--    <div class="sidenav">--%>
    <%--        <input class="btn btn-outline-success" type="submit" name="sort" value="name">--%>
    <%--        <input class="btn btn-outline-success" type="submit" name="sort" value="date">--%>
    <%--        <input class="btn btn-outline-success" type="submit" name="sort" value="who create">--%>
    <%--        <input class="btn btn-outline-success" type="submit" name="sort" value="with whom">--%>
    <%--        <input class="btn btn-outline-success" type="submit" name="sort" value="period">--%>
    <%--    </div>--%>
    <select class="btn btn-outline-success" name="sort">
        <option value="name" >name</option>
        <option value="date">date</option>
        <option value="who create">who create</option>
        <option value="with whom">with whom</option>
        <option value="period">period</option>
    </select>
    <button class="btn btn-outline-success" type="submit">Sort</button>
</form>

<table class="table">
    <thead>
    <tr>
        <th scope="col"></th>
        <th scope="col">Name</th>
        <c:forEach begin="0" end="20">
            <th scope="col"></th>
        </c:forEach>
        <th scope="col">Create date</th>
        <th scope="col">Who create</th>
        <th scope="col">With whom</th>
        <th scope="col">Period of execution</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${documentsList}" var="document">
        <tr>
            <td></td>
            <td><a href="/doc/document/${document.documentId}"/>${document.documentName.documentName}</td>
            <c:forEach begin="0" end="20">
                <td></td>
            </c:forEach>
            <td>${document.createDate}</td>
            <td>${document.personWhoConcludedContract}</td>
            <td>${document.personWithWhomTheContractWasSigned}</td>
            <td>${document.periodOfExecution}</td>
            <td>
                <form action="/doc/document/edit/${document.documentId}" method="get">
                    <button class="btn btn-outline-success" type="submit">Edit</button>
                </form>
                    <%--                <button type="submit"><a href="/doc/document/edit/${document.documentId}">  Edit   </a> </button>--%>
            </td>
            <td>
                <form action="/doc/document/delete/${document.documentId}" method="post">
                    <button class="btn btn-outline-success" type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/doc/document/search" method="post">
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