<%--
  Created by IntelliJ IDEA.
  User: Dina Maskalik
  Date: 13.03.2021
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>

<jsp:include page="header.jsp"/>

<h1>
    Document:
</h1>

<td><h5>Document name</h5></td>

<table class="table">
    <tr>
        <td>${document.documentName.documentName}</td>
    </tr>
</table>

<table class="table">
    <tr>
        <td><h5>Author</h5></td>
        <td><h5>Who create</h5></td>
        <td><h5>With whom</h5></td>
    </tr>
    <tr>
        <td>${document.author}</td>
        <td>${document.personWhoConcludedContract}</td>
        <td>${document.personWithWhomTheContractWasSigned}</td>
    </tr>
</table>

<table class="table">
    <tr>
        <td><h5>Create date</h5></td>
        <td><h5>Period of execution</h5></td>
    </tr>
    <tr>
        <td>${document.createDate}</td>
        <td>${document.periodOfExecution}</td>
    </tr>
</table>

<table class="table">
    <tr>
        <td><h5>Content</h5></td>
    </tr>

</table>
<textarea type="text" class="form-control" placeholder="content" aria-label="content"
          aria-describedby="basic-addon5" name="content"
          rows="12" disabled="disabled">${document.content.content}</textarea>
<h1></h1>

<jsp:include page="footer.jsp"/>
