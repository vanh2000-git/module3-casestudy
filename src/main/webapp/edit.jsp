<%--
  Created by IntelliJ IDEA.
  User: SON
  Date: 2/12/2025
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Room</title>
</head>
<body>
<form action="rooms?action=edit" method="post">
    <label>ID room: ${room.id}</label>
    <input type="hidden" name="id" value="${room.id}">

    <label for="name">Tên room:</label>
    <input type="text" id="name" name="name" value="${room.name}">

    <label for="description">Mo ta:</label>
    <input type="text" id="description" name="description" value="${room.description}">

    <label for="location">Dia Diem</label>
    <input type="text" id="location" name="location" value="${room.location}">

    <label for="price">Gia:</label>
    <input type="number" id="price" name="price" value="${room.price}">

    <label for="img">Hinh anh:</label>
    <input type="text" id="img" name="img" value="${room.img}">


    <label for="status">Trang thai:</label>
    <input type="text" id="status" name="status" value="${room.status}">


    <button type="submit">Update room</button>
</form>
</body>
</html>
