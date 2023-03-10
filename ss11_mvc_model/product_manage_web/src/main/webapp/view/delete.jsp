<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 1/3/2023
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Deleting product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
  <a href="/products">Back to product list</a>
</p>
<form method="post" action="/products?action=delete&id=${product.id}">
  <h3>Are you sure?</h3>
  <fieldset>
    <legend>Product information</legend>
    <table>
      <tr>
        <td>Id: </td>
        <td>${requestScope["product"].getId()}</td>
      </tr>
      <tr>
        <td>Name: </td>
        <td>${requestScope["product"].getName()}</td>
      </tr>
      <tr>
        <td>Price : </td>
        <td>${requestScope["product"].getPrice()}</td>
      </tr>
      <tr>
        <td>Description: </td>
        <td>${requestScope["product"].getDescription()}</td>
      </tr>
      <tr>
        <td>Maker: </td>
        <td>${requestScope["product"].getMaker()}</td>
      </tr>
      <tr>
        <td><input type="submit" value="Delete product"></td>
        <td><a href="/products">Back to product list</a></td>
      </tr>
    </table>
  </fieldset>
  </form>
</body>
</html>
