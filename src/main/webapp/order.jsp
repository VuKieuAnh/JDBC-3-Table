<%--
  Created by IntelliJ IDEA.
  User: kieuanh
  Date: 07/05/2024
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Mua san pham</h1>
<form method="post">
    <table>
        <tr>
            <td>name</td>
            <td><input disabled value="${product.name}"></td>
        </tr>
        <tr>
            <td>description</td>
            <td><input disabled value="${product.description}"></td>
        </tr>
        <tr>
            <td>user</td>
            <td><select name="userid">
                <c:forEach var="u" items="${users}">
                    <option value="${u.id}">${u.name}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td>number</td>
            <td><input  name="number" placeholder="number"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="order"></td>
        </tr>
    </table>

</form>


</body>
</html>
