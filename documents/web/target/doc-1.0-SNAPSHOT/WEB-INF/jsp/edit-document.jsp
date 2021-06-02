<%--
  Created by IntelliJ IDEA.
  User: Dina Maskalik
  Date: 11.03.2021
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<form action="/doc/document/edit/${document.documentId}" method="post">
<%--<form action="/doc/document/edit" method="post">--%>
    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">Document name</span>
        <input type="text" class="form-control" placeholder="document name" aria-label="document name"
               aria-describedby="basic-addon1" name="documentName" value="${document.documentName.documentName}">
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon2">Who create contract</span>
        <input type="text" class="form-control" placeholder="who create contract" aria-label="who create contract"
                  aria-describedby="basic-addon2" name="personWhoConcludedContract" value="${document.personWhoConcludedContract}">
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon3">With whom create contract</span>
        <input type="text" class="form-control" placeholder="with whom contract was signed" aria-label="with whom contract was signed"
                  aria-describedby="basic-addon3" name="personWithWhomTheContractWasSigned" value="${document.personWithWhomTheContractWasSigned}">
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon4">Period of execution</span>
        <input type="text" class="form-control" placeholder="period of execution" aria-label="period of execution"
                  aria-describedby="basic-addon4" name="periodOfExecution" value="${document.periodOfExecution}">
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon5">Content</span>
        <textarea type="text" class="form-control" placeholder="content" aria-label="content"
                  aria-describedby="basic-addon5" name="content" rows="13">${document.content.content}</textarea>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

