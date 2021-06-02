<%--
  Created by IntelliJ IDEA.
  User: Dina Maskalik
  Date: 13.03.2021
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="windows-1251" %>
<jsp:include page="header.jsp"/>

<h1>
    Документ:
</h1>

<td><h5>Наименование:</h5></td>

<table class="table">
    <tr>
        <td>${document.documentName.documentName}</td>
    </tr>
</table>

<table class="table">
    <tr>
        <td><h5>Автор:</h5></td>
        <td><h5>Кто заключал</h5></td>
        <td><h5>С кем заключал</h5></td>
    </tr>
    <tr>
        <td>${document.author.author}</td>
        <td>${document.personWhoConcludedContract.personWhoConcludedContract}</td>
        <td>${document.personWithWhomTheContractWasSigned.personWithWhomTheContractWasSigned}</td>
    </tr>
</table>

<table class="table">
    <tr>
        <td><h5>Дата создания</h5></td>
        <td><h5>Срок выполнения</h5></td>
    </tr>
    <tr>
        <td>${document.createDate}</td>
        <td>${document.periodOfExecution.periodOfExecution}</td>
    </tr>
</table>

<table class="table">
    <tr>
        <td><h5>Содержание</h5></td>
    </tr>
</table>
<textarea type="text" class="form-control" placeholder="content" aria-label="content"
          aria-describedby="basic-addon5" name="content"
          rows="12" disabled="disabled">${document.content.content}</textarea>
<h1></h1>

<jsp:include page="footer.jsp"/>
