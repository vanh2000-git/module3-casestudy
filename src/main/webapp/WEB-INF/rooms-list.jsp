<%--
  Created by IntelliJ IDEA.
  User: SON
  Date: 2/11/2025
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>room-list</title>
</head>
<body>
<h1>DANH SÁCH PHÒNG</h1>
    <table border="1px">
<tr>

    <td>name</td>
    <td>description</td>
    <td>location</td>
    <td>price</td>
    <td>img</td>
    <td>status</td>
</tr>
<c:forEach items="${rooms}" var ="r">
<tr>

    <td>${r.getName()}</td>
    <td>${r.getDescription()}</td>
    <td>${r.getLocation()}</td>
    <td>${r.getPrice()}</td>
    <td>${r.getImg()}</td>
    <td>${r.getStatus()}</td>
    <td>
        <a href="rooms?action=edit&id=${r.id}" >Edit</a>

        <a href="rooms?action=delete&id=${r.id}"
           onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Delete</a>
    </td>
</tr>

</c:forEach>
    </table>
</body>
</html>
