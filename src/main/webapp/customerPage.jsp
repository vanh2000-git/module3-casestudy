<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Khách Hàng</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .navbar {
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .customer-card {
            border-radius: 15px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        .btn-primary-custom {
            background-color: #007bff;
            border: none;
            transition: all 0.3s ease-in-out;
        }

        .btn-primary-custom:hover {
            background-color: #0056b3;
            transform: translateY(-2px);
        }

        .room-card {
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease-in-out;
        }

        .room-card:hover {
            transform: scale(1.03);
        }

        .card-img-top {
            height: 200px;
            object-fit: cover;
        }

        .user-badge {
            background-color: #dc3545;
            color: white;
            font-weight: bold;
            padding: 8px 15px;
            border-radius: 20px;
        }
    </style>
</head>
<body>

<!-- Header -->
<nav class="navbar navbar-expand-lg navbar-light bg-white fixed-top">
    <div class="container">
        <a class="navbar-brand fw-bold text-primary" href="#">C1024G1</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="index.jsp">Trang Chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="customerBooking?userId=${userId}">Danh sách đơn đã đặt</a>
                </li>
                <li class="nav-item ms-3">
                    <span class="user-badge">${userName}</span>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Hero Section -->
<div class="container mt-5 pt-5">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-9">
            <h3 class="mb-4">Danh Sách Phòng</h3>
            <div class="row">

                <c:forEach var="room" items="${rooms}">
                    <c:if test="${room.status == 'available'}">  <%-- Chỉ hiển thị phòng có status = available --%>
                        <div class="col-md-4 mb-4">
                            <div class="card room-card">
                                <img src="${room.img}" class="card-img-top" alt="Room Image">
                                <div class="card-body text-center">
                                    <h5 class="card-title">${room.name}</h5>
                                    <p class="card-text fw-bold text-danger">Giá: ${room.price} VNĐ</p>
                                    <a href="booking-form.jsp?userId=${userId}&roomId=${room.id}&roomPrice=${room.price}"
                                       class="btn btn-primary-custom w-100">Đặt Phòng</a>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>


            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="bg-white mt-5 py-3">
    <div class="container text-center">
        <p class="mb-0">&copy; 2025 - C1024G1. Tất cả các quyền được bảo lưu.</p>
    </div>
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
