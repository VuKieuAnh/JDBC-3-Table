<%--
  Created by IntelliJ IDEA.
  User: kieuanh
  Date: 07/05/2024
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>danh sach sp</title>
</head>
<body>
<h1>Danh sach san pham</h1>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>number</td>
        <td>description</td>
        <td>mua</td>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.number}</td>
            <td>${p.description}</td>
            <td><a href="/order?id=${p.id}">Mua</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
