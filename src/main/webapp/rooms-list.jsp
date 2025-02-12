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
    <link rel="stylesheet" href="../css/css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
            text-transform: uppercase;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        td img {
            width: 80px;
            height: 80px;
            object-fit: cover;
            border-radius: 4px;
        }

        a {
            text-decoration: none;
            padding: 6px 12px;
            border-radius: 4px;
            font-weight: bold;
            color: white;
        }

        a[href*="edit"] {
            background-color: #ffa500;
        }

        a[href*="delete"] {
            background-color: #ff4d4d;
        }

        a:hover {
            opacity: 0.8;
        }

        button {
            display: block;
            margin: 20px auto;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-white fixed-top">
    <div class="container">
        <a class="navbar-brand fw-bold text-primary" href="#">Admin Page - Trang Quan Tri</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/history_booking">History</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<br>
<br>
<br>

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
<button onclick="window.location.href='create.jsp'">Tạo mới</button>



<footer class="bg-white mt-5 py-3">
    <div class="container text-center">
        <p>&copy; 2025 - C1024G1. Tất cả các quyền được bảo lưu.</p>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
