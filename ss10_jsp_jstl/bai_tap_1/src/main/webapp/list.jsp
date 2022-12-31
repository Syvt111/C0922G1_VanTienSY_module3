<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 12/30/2022
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Danh sánh khách hàng</h1>
<table style="width: 600px; height: 600px;border: 2px solid; background: #b6d4fe">
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Name</th>
        <th scope="col">Birthday</th>
        <th scope="col">Address</th>
        <th scope="col">Image</th>
    </tr >
    <c:forEach var="customer" items="${customerList}" varStatus="status">
        <tr style="align-content: center">
            <td>${status.count}</td>
            <td>${customer.name}</td>
            <td>${customer.birthday}</td>
            <td>${customer.address}</td>
            <td><img src=${customer.image}  width="100" height="100"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
