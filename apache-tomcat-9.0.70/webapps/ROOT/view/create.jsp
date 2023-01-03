<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 1/3/2023
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new product</title>
  <style>
    .message{
      color:green;
    }
  </style>
</head>
<body>
<h1>Create new product</h1>
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
        <td>Id: </td>
        <td><input type="text" name="Id" id="id"></td>
      </tr>
      <tr>
        <td>Name: </td>
        <td><input type="text" name="Name" id="name"></td>
      </tr>
      <tr>
        <td>Price: </td>
        <td><input type="text" name="Price" id="price"></td>
      </tr>
      <tr>
        <td>Description: </td>
        <td><input type="text" name="Description" id="description"></td>
      </tr>
      <tr>
        <td>Maker: </td>
        <td><input type="text" name="Maker" id="maker"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Create product"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
