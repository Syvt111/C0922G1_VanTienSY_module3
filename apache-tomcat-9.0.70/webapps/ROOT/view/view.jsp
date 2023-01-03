
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product detail</title>
</head>
<body>
<h1>Product details</h1>
<p>
  <a href="/products">Back to product list</a>
</p>
<table>
  <tr>
    <td>ID: </td>
    <td>${requestScope["product"].getId()}</td>
  </tr>
  <tr>
    <td>Name: </td>
    <td>${requestScope["product"].getName()}</td>
  </tr>
  <tr>
    <td>Price: </td>
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
</table>
</body>
</html>
