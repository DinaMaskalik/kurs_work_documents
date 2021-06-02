<%--
  Created by IntelliJ IDEA.
  User: Dina Maskalik
  Date: 12.03.2021
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
    #addForm {
        background-color: #ffffff;
        margin: 100px auto;
        padding: 40px;
        width: 70%;
        min-width: 300px;
    }

    /* Style the input fields */
    input, textarea {
        padding: 10px;
        width: 100%;
        font-size: 17px;
        font-family: Raleway;
        border: 1px solid #aaaaaa;
    }

    /* Mark input boxes that gets an error on validation: */
    input.invalid {
        background-color: #ffdddd;
    }

    /* Hide all steps by default: */
    .tab {
        display: none;
    }

    /* Make circles that indicate the steps of the form: */
    .step {
        height: 15px;
        width: 15px;
        margin: 0 2px;
        background-color: #bbbbbb;
        border: none;
        border-radius: 50%;
        display: inline-block;
        opacity: 0.5;
    }

    /* Mark the active step: */
    .step.active {
        opacity: 1;
    }

    /* Mark the steps that are finished and valid: */
    .step.finish {
        background-color: #4CAF50;
    }

</style>
<jsp:include page="header.jsp"/>

<%--<form:form action="/doc/document/add" method="post" modelAttribute="document">--%>
<%--    &lt;%&ndash;<form action="/doc/document/edit" method="post">&ndash;%&gt;--%>
<%--    <div class="input-group mb-3">--%>
<%--        <span class="input-group-text" id="basic-addon1">Document name</span>--%>
<%--        <form:input path="documentName" type="text" class="form-control" placeholder="document name"--%>
<%--                    aria-label="document name"--%>
<%--                    aria-describedby="basic-addon1"/>--%>
<%--        <form:errors path="documentName" cssClass="error"/>--%>
<%--    </div>--%>

<%--    <div class="input-group mb-3">--%>
<%--        <span class="input-group-text" id="basic-addon6">Author</span>--%>
<%--        <form:input path="author" type="text" class="form-control" placeholder="author" aria-label="author"--%>
<%--                    aria-describedby="basic-addon6"/>--%>
<%--        <form:errors path="author" cssClass="error"/>--%>
<%--    </div>--%>

<%--    <div class="input-group mb-3">--%>
<%--        <span class="input-group-text" id="basic-addon2">Who create contract</span>--%>
<%--        <form:input type="text" class="form-control" placeholder="who create contract" aria-label="who create contract"--%>
<%--                    aria-describedby="basic-addon2" path="personWhoConcludedContract"/>--%>
<%--        <form:errors path="personWhoConcludedContract" cssClass="error"/>--%>

<%--    </div>--%>

<%--    <div class="input-group mb-3">--%>
<%--        <span class="input-group-text" id="basic-addon3">With whom create contract</span>--%>
<%--        <form:input type="text" class="form-control" placeholder="with whom contract was signed"--%>
<%--                    aria-label="with whom contract was signed"--%>
<%--                    aria-describedby="basic-addon3" path="personWithWhomTheContractWasSigned"/>--%>
<%--        <form:errors path="personWithWhomTheContractWasSigned" cssClass="error"/>--%>


<%--    </div>--%>

<%--    <div class="input-group mb-3">--%>
<%--        <span class="input-group-text" id="basic-addon4">Period of execution</span>--%>
<%--        <form:input type="text" class="form-control" placeholder="period of execution" aria-label="period of execution"--%>
<%--                    aria-describedby="basic-addon4" path="periodOfExecution"/>--%>
<%--        <form:errors path="periodOfExecution" cssClass="error"/>--%>

<%--    </div>--%>

<%--    <div class="input-group mb-3">--%>
<%--        <span class="input-group-text" id="basic-addon5">Content</span>--%>
<%--        <form:textarea type="text" class="form-control" placeholder="content" aria-label="content"--%>
<%--                       aria-describedby="basic-addon5" rows="12" path="content"/>--%>
<%--        <form:errors path="content" cssClass="error"/>--%>

<%--    </div>--%>
<%--    <button type="submit" class="btn btn-primary">Add</button>--%>
<%--</form:form>--%>

<form id="addForm" action="/doc/document/add" method="post">

    <h1>Add document:</h1>

    <!-- One "tab" for each step in the form: -->
    <div class="tab">Name, author:
        <p><input placeholder="Document name..." oninput="this.className = ''" name="documentName"></p>
        <p><input placeholder="Author..." oninput="this.className = ''" name="author"></p>
    </div>

    <div class="tab">Person info:
        <p><input placeholder="Who create..." oninput="this.className = ''"
                  name="personWhoConcludedContract"></p>
        <p><input placeholder="With whom..." oninput="this.className = ''"
                  name="personWithWhomTheContractWasSigned"></p>
    </div>

    <div class="tab">Period of execution:
        <p><input placeholder="Period of execution..." oninput="this.className = ''"
                  name="periodOfExecution"></p>
    </div>

    <div class="tab">Content:
        <p><textarea placeholder="Content..." oninput="this.className = ''"
                     name="content"></textarea></p>
        <%--        <p><input placeholder="Password..." oninput="this.className = ''"></p>--%>
    </div>

    <div style="overflow:auto;">
        <div style="float:right;">
            <button type="button" class="btn btn-primary" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
            <button type="button" class="btn btn-primary" id="nextBtn" onclick="nextPrev(1)">Next</button>
        </div>
    </div>

    <!-- Circles which indicates the steps of the form: -->
    <div style="text-align:center;margin-top:40px;">
        <span class="step"></span>
        <span class="step"></span>
        <span class="step"></span>
        <span class="step"></span>
    </div>

</form>

<script>
    var currentTab = 0; // Current tab is set to be the first tab (0)
    showTab(currentTab); // Display the current tab

    function showTab(n) {
        // This function will display the specified tab of the form ...
        var x = document.getElementsByClassName("tab");
        x[n].style.display = "block";
        // ... and fix the Previous/Next buttons:
        if (n == 0) {
            document.getElementById("prevBtn").style.display = "none";
        } else {
            document.getElementById("prevBtn").style.display = "inline";
        }
        if (n == (x.length - 1)) {
            document.getElementById("nextBtn").innerHTML = "Submit";
        } else {
            document.getElementById("nextBtn").innerHTML = "Next";
        }
        // ... and run a function that displays the correct step indicator:
        fixStepIndicator(n)
    }

    function nextPrev(n) {
        // This function will figure out which tab to display
        var x = document.getElementsByClassName("tab");
        // Exit the function if any field in the current tab is invalid:
        if (n == 1 && !validateForm()) return false;
        // Hide the current tab:
        x[currentTab].style.display = "none";
        // Increase or decrease the current tab by 1:
        currentTab = currentTab + n;
        // if you have reached the end of the form... :
        if (currentTab >= x.length) {
            //...the form gets submitted:
            document.getElementById("addForm").submit();
            return false;
        }
        // Otherwise, display the correct tab:
        showTab(currentTab);
    }

    function validateForm() {
        // This function deals with validation of the form fields
        var x, y, i, valid = true, z;
        x = document.getElementsByClassName("tab");
        y = x[currentTab].getElementsByTagName("input");
        z = document.getElementsByClassName("tab_1");
        // A loop that checks every input field in the current tab:
        for (i = 0; i < y.length; i++) {
            // If a field is empty...
            if (y[i].value == "") {
                // add an "invalid" class to the field:
                y[i].className += " invalid";
                // and set the current valid status to false:
                valid = false;
            }
        }
        // If the valid status is true, mark the step as finished and valid:
        if (valid) {
            document.getElementsByClassName("step")[currentTab].className += " finish";
        }
        return valid; // return the valid status
    }

    function fixStepIndicator(n) {
        // This function removes the "active" class of all steps...
        var i, x = document.getElementsByClassName("step");
        for (i = 0; i < x.length; i++) {
            x[i].className = x[i].className.replace(" active", "");
        }
        //... and adds the "active" class to the current step:
        x[n].className += " active";
    }
</script>

<jsp:include page="footer.jsp"/>


