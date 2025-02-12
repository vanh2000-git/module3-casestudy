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
    <link rel="stylesheet" href="../css/css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        form {
            width: 50%;
            margin: 30px auto;
            padding: 20px;
            background: white;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: left;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }

        input {
            width: 96%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            display: block;
        }

        input:focus {
            border-color: #007bff;
            outline: none;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #28a745;
            color: white;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 15px;
        }

        button:hover {
            background-color: #218838;
        }

        form label:first-child {
            font-size: 18px;
            color: #333;
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
<footer class="bg-white mt-5 py-3">
    <div class="container text-center">
        <p>&copy; 2025 - C1024G1. Tất cả các quyền được bảo lưu.</p>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
