<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="../bootstrap-5.0.2-dist/css/bootstrap.css">
</head>
<body>
<form action="/products">
<h1>Products</h1>
<div>
    <a href="/products?action=create">Create new product</a>
</div>
<div>

    <input type="text" name="id" value="id" placeholder="Enter id to find">
    <button type="submit"name="action"value="find">Find</button>
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
        <c:forEach items="${products}" var="product" varStatus="">
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
        </c:forEach>
    </table>
</div>
</form>
</body>
<link rel="stylesheet" href="../bootstrap-5.0.2-dist/js/bootstrap.bundle.js">
</html>