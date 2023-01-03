<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 1/3/2023
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Customer</h1>
<p>
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p>
  <a href="/products">Back to product list</a>
</p>
<form method="post">
  <fieldset>
    <legend>Product information</legend>
    <table>
      <tr>
        <td>ID: </td>
        <td><input type="text" name="Id" id="id" value="${requestScope["product"].getId()}"></td>
      </tr>
      <tr>
        <td>Name: </td>
        <td><input type="text" name="Name" id="name" value="${requestScope["product"].getName()}"></td>
      </tr>
      <tr>
        <td>Price: </td>
        <td><input type="text" name="Price" id="price" value="${requestScope["product"].getPrice()}"></td>
      </tr>
      <tr>
      <tr>
        <td>Description: </td>
        <td><input type="text" name="Description" id="description" value="${requestScope["product"].getDescription()}"></td>
      </tr>
      <tr>
        <td>Maker: </td>
        <td><input type="text" name="Maker" id="maker" value="${requestScope["product"].getMaker()}"></td>
      </tr>
        <td></td>
        <td><input type="submit" value="Update product"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
