<%--
  Created by IntelliJ IDEA.
  User: kieuanh
  Date: 08/05/2024
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit order</h1>
<form method="post">
    <table>
        <tr>
            <td>name</td>
            <td><input disabled value="${cart.user}"></td>
        </tr>
        <tr>
            <td>user</td>
            <td>
                <input disabled value="${cart.productname}">
            </td>
        </tr>
        <tr>
            <td>number</td>
            <td><input  name="number" value="${cart.number}}" placeholder="number"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="order"></td>
        </tr>
    </table>
</form>
</body>
</html>
