<%--
  Created by IntelliJ IDEA.
  User: Dina Maskalik
  Date: 08.05.2021
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="windows-1251" %>

<style>
    form {
        border: 3px solid #f1f1f1;
    }

    /* Full-width inputs */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    /* Set a style for all buttons */
    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }

    /* Add a hover effect for buttons */
    button:hover {
        opacity: 0.8;
    }

    /* Extra style for the cancel button (red) */
    .cancelbtn {
        width: auto;
        padding: 10px 18px;
        background-color: #f44336;
    }

    /* Center the avatar image inside this container */
    .imgcontainer {
        text-align: center;
        margin: 24px 0 12px 0;
    }

    /* Avatar image */
    img.avatar {
        width: 40%;
        border-radius: 50%;
    }

    /* Add padding to containers */
    .container {
        padding: 16px;
    }

    /* The "Forgot password" text */
    span.psw {
        float: right;
        padding-top: 16px;
    }

    /* Change styles for span and cancel button on extra small screens */
    @media screen and (max-width: 300px) {
        span.psw {
            display: block;
            float: none;
        }
        .cancelbtn {
            width: 100%;
        }
    }
</style>
<h2 style="text-align:center">Авторизация</h2>

<form action="/doc/login" method="post">
<%--    <div class="imgcontainer">--%>
<%--        <img src="1.jpg" alt="Avatar" class="avatar">--%>
<%--    </div>--%>

    <div class="container">
        <label id="username" for="username"><b>Логин</b></label>
        <input name="username" type="text" placeholder="Enter Username" name="uname" required>

        <label for="password"><b>Пароль</b></label>
        <input name="password" type="password" id="myInput" placeholder="Enter Password" name="psw" required>
<%--        Password: <input type="password" value="FakePSW" id="myInput">--%>

        <button type="submit">Авторизоваться</button>

    </div>
</form>
<form method="get" action="/doc/registration/">
    <div class="container" style="background-color:#f1f1f1">
        <button type="submit" class="cancelbtn">Регистрация</button>
        <span class="psw">Забыли <a href="#">пароль?</a></span>
    </div>
</form>



