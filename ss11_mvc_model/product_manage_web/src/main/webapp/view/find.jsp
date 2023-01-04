<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 1/4/2023
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find Product</title>
    <link rel="stylesheet" href="../bootstrap-5.0.2-dist/css/bootstrap.css">
</head>
<body>
<h1>Product : ${product.name}</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table class="table-light" border="1">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Description</th>
        <th scope="col">Maker</th>
        <th scope="col">View</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    <tr>
        <td scope="col">${product.id}</td>
        <td scope="col">${product.name}</td>
        <td scope="col">${product.price}</td>
        <td scope="col">${product.description}</td>
        <td scope="col">${product.maker}</td>
        <td scope="col"><a href="/products?action=view&id=${product.id}">${product.getName()}</a></td>
        <td scope="col"><a href="/products?action=edit&id=${product.id}">edit</a></td>
        <td scope="col"><a href="/products?action=delete&id=${product.id}">delete</a></td>
    </tr>
</table>
</body>
<link rel="stylesheet" href="../bootstrap-5.0.2-dist/js/bootstrap.bundle.js">
</html>
