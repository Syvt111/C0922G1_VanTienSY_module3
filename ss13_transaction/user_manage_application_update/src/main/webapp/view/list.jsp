<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management Application</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<body>
<center>
    <h1><a href="/users">User Management</a></h1>

</center>
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
<table class="table table-striped" >

        <tr>
            <th >ID</th>
            <th >Name<a href="/users?action=sort"><button class="btn btn-outline-dark" type="submit"name="action"value="sort">Sort</button></a> </th>
            <th >Email</th>
            <th >Country</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td > <c:out value="${user.name}"/></td>
                <td ><c:out value="${user.email}"/></td>
                <td ><c:out value="${user.country}"/></td>
                <td>
                    <a class="btn btn-outline-secondary" href="/users?action=edit&id=${user.id}">Edit</a>
                </td>
                <td>
                    <a class="btn btn-outline-danger" href="/users?action=delete&id=${user.id}">Delete</a>

                </td>
            </tr>
        </c:forEach>
</table>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</html>