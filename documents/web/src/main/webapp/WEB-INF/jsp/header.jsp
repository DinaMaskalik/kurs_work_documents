<%@ page import="it.academy.user.UserRoleUtil" %><%--
  Created by IntelliJ IDEA.
  User: Dina Maskalik
  Date: 09.03.2021
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<style>
    .topnav {
        overflow: hidden;
        background-color: #e9e9e9;
    }

    /* Style the links inside the navigation bar */
    .topnav a {
        float: left;
        display: block;
        color: black;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
    }

    /* Change the color of links on hover */
    .topnav a:hover {
        background-color: #ddd;
        color: black;
    }

    /* Style the "active" element to highlight the current page */
    .topnav a.active {
        background-color: #2196F3;
        color: white;
    }

    /* Style the search box inside the navigation bar */
    .topnav input[type=text] {
        float: right;
        padding: 6px;
        border: none;
        margin-top: 8px;
        margin-right: 16px;
        font-size: 17px;
    }

    /* When the screen is less than 600px wide, stack the links and the search field vertically instead of horizontally */
    @media screen and (max-width: 600px) {
        .topnav a, .topnav input[type=text] {
            float: none;
            display: block;
            text-align: left;
            width: 100%;
            margin: 0;
            padding: 14px;
        }
        .topnav input[type=text] {
            border: 1px solid #ccc;
        }
    }
</style>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="windows-1251" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<!-- Navigation bar -->
<%--<div class="topnav">--%>
<%--    <a class="navbar-brand" href="/doc/document">Doc</a>--%>
<%--    <a class="active" href="/doc/document">Главная</a>--%>
<%--    <a href="/doc/document/add">Добавить документ</a>--%>
<%--    <a href="/doc/document/filter">Фильтр</a>--%>
<%--    &lt;%&ndash;    сделать для админа просмотр всех записей с пользователями &ndash;%&gt;--%>
<%--    <a href="#contact">Просмотр аккаунтов</a>--%>
<%--    <a href="#contact">Составить отчёт</a>--%>

<%--    <form action="/doc/document/search" method="post" class="d-flex">--%>
<%--        <input name="searchParam" class="form-control me-2" type="search" placeholder="Search"--%>
<%--               aria-label="Search">--%>
<%--        <button class="btn btn-outline-success" type="submit">Поиск</button>--%>
<%--        <div></div>--%>
<%--        <div></div>--%>
<%--    </form>--%>

<%--    <form action="/doc/login" method="get" class="d-flex">--%>
<%--        <button class="btn btn-outline-success" type="submit">Выйти</button>--%>
<%--    </form>--%>
<%--</div>--%>
<%--<form action="/doc/document/search" method="post" class="d-flex">--%>
<%--    <input name="searchParam" class="form-control me-2" type="search" placeholder="Search"--%>
<%--           aria-label="Search">--%>
<%--    <button class="btn btn-outline-success" type="submit">Поиск</button>--%>
<%--    <div></div>--%>
<%--</form>--%>
<%--<form action="/doc/login" method="get" class="d-flex">--%>
<%--    <button class="btn btn-outline-success" type="submit">Выйти</button>--%>
<%--</form>--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/doc/document">Doc</a>
        <%--        <img src="image/logo.png">--%>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/doc/document">Главная</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/doc/document/add">Добавить документ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/doc/document/filter">Фильтр</a>
                </li>

                <%
                    if ("ROLE_ADMIN".equals(UserRoleUtil.getRole())) {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="/doc/account/">Просмотр аккаунтов</a>
                </li>
                <%
                    }
                %>
            </ul>

            <form action="/doc/document/search" method="post" class="d-flex">
                <input name="searchParam" class="form-control me-2" type="search" placeholder="Search"
                       aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Поиск</button>
                <div></div>
            </form>
            <form action="/doc/login" method="get" class="d-flex">
                <button class="btn btn-outline-success" type="submit">Выйти</button>
            </form>
        </div>
    </div>
</nav>
