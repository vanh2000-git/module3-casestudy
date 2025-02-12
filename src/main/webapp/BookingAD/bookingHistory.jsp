<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lịch sử Booking</title>
    <link rel="stylesheet" href="../css/css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .filter-container {
            margin-bottom: 20px;
            text-align: center;
        }
        select, button {
            padding: 8px;
            margin: 5px;
        }
    </style>
</head>
<body>

<h2>Lịch sử Booking</h2>
<nav class="navbar navbar-expand-lg navbar-light bg-white fixed-top">
    <div class="container">
        <a class="navbar-brand fw-bold text-primary" href="#">C1024G1</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/rooms">Room</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- Bộ lọc -->
<div class="filter-container">
    <form action="history_booking" method="GET">
        <label for="location">Chọn địa điểm:</label>
        <select name="location" id="location">
            <option value="">-- Tất cả --</option>
            <c:forEach items="${locations}" var="loc">
                <option value="${loc}" ${param.location == loc ? 'selected' : ''}>${loc}</option>
            </c:forEach>
        </select>

        <label for="status">Chọn trạng thái:</label>
        <select name="status" id="status">
            <option value="">-- Tất cả --</option>
            <c:forEach items="${statuses}" var="st">
                <option value="${st}" ${param.status == st ? 'selected' : ''}>${st}</option>
            </c:forEach>
        </select>

        <button type="submit">Lọc</button>
    </form>
</div>

<c:if test="${not empty sessionScope.message}">
    <p style="color: green; text-align: center;">${sessionScope.message}</p>
    <c:remove var="message" scope="session"/>
</c:if>
<c:if test="${not empty sessionScope.error}">
    <p style="color: red; text-align: center;">${sessionScope.error}</p>
    <c:remove var="error" scope="session"/>
</c:if>

<table>
    <tr>
        <th>ID</th>
        <th>User</th>
        <th>Room</th>
        <th>Check-in</th>
        <th>Check-out</th>
        <th>Status</th>
        <th>Total Amount</th>
    </tr>
    <c:forEach items="${bookings}" var="booking">
        <tr>
            <td>${booking.bookingId}</td>
            <td>${booking.customerName} - ${booking.customerPhone}</td>
            <td>${booking.roomName} - ${booking.roomLocation}</td>
            <td>${booking.checkIn}</td>
            <td>${booking.checkOut}</td>
            <td>
                <form action="history_booking" method="POST">
                    <input type="hidden" name="bookingId" value="${booking.bookingId}" />
                    <select name="status">
                        <c:forEach items="${statuses}" var="st">
                            <option value="${st}" ${booking.bookingStatus == st ? 'selected' : ''}>${st}</option>
                        </c:forEach>
                    </select>
                    <button type="submit">Cập nhật</button>
                </form>
            </td>
            <td>$${booking.totalAmount}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6" style="text-align: right; font-weight: bold;">Tổng tiền:</td>
        <td style="font-weight: bold;">$${totalAmount}</td>
    </tr>
</table>
<footer class="bg-white mt-5 py-3">
    <div class="container text-center">
        <p>&copy; 2025 - C1024G1. Tất cả các quyền được bảo lưu.</p>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
