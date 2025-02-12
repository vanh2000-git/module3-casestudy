<%--
  Created by IntelliJ IDEA.
  User: SON
  Date: 2/11/2025
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="rooms?action=create" method="post">

    <input type="text" name="name" placeholder="Name">
    <input type="text" name="description" placeholder="Description">
    <input type="text" name="location" placeholder="Location">
    <input type="number" name="price" placeholder="Price">
    <input type="text" name="img" placeholder="Hinh anh">
    <input type="text" name="status" placeholder="Status">

    <button type = "submit"> Submit </button>
</form>
</body>
</html>
