<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Products</h1>
<div>
    <a href="/products?action=create">Create new product</a>
</div>
<div>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Maker</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${products}" var="product" varStatus="">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>${product.maker}</td>
                <td><a href="/products/?action=edit">edit</a></td>
                <td><a href="/products/?action=delete">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>