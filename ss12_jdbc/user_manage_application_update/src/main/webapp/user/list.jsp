<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="../bootstrap-5.0.2-dist/css/bootstrap.css">
</head>
<body>
<center>
    <h1><a href="/users">User Management</a></h1>

</center>
<form action="/users">

<div align="center">
    <h2>List of Users</h2>
    <a href="/users?action=create">Add New User</a> <br>
    <table class="table-striped">
        <tr>
            <input type="text" name="country" placeholder="Enter Country">
            <button type="submit" name="action" value="find">Find</button>
        </tr>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Country</th>
            <th scope="col">Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td scope="col"><c:out value="${user.id}"/></td>
                <td scope="col"> <c:out value="${user.name}"/></td>
                <td scope="col"><c:out value="${user.email}"/></td>
                <td scope="col><c:out value="${user.country}"/></td>
                <td scope="col>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</form>
</body>
<script src="../bootstrap-5.0.2-dist/js/bootstrap.bundle.js"></script>
</html>