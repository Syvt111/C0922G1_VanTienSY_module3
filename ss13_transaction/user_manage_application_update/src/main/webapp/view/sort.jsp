<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 1/4/2023
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List user sorted by name</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

<body>
<h1>LIST USER SORTED BY NAME</h1>
<form action="/users">
    <h2>List of Users</h2>
    <a href="/users?action=create">Add New User</a> <br>
    <form class="d-flex" role="search">
        <div class="row">
            <div class="col-sm-10">
                <input class="form-control me-2 flex-md-row " type="search" name="country" placeholder="Enter Country to search" aria-label="Search">
            </div>
            <div class="col-sm-4">
                <button class="btn btn-outline-success small"name="action" value="find" type="submit">Search</button>
            </div >
        </div>
    </form>
<table class="table table-striped">
    <tr>
        <td>ID</td>
        <td>Name User</td>
        <td>Email</td>
        <td>Country</td><th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td>
                <a class="btn btn-outline-secondary" href="/users?action=edit&id=${user.id}">Edit</a>
            </td>
            <td>
                <a class="btn btn-outline-danger" href="/users?action=delete&id=${user.id}">Delete</a>

            </td>
        </tr>
    </c:forEach>
</table>
<a href="/User?action=uers"><h3>Comeback list user</h3></a>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</html>
