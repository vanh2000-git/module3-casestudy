<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lịch sử Booking</title>
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
            <td>${booking.bookingStatus}</td>
            <td>$${booking.totalAmount}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6" style="text-align: right; font-weight: bold;">Tổng tiền:</td>
        <td style="font-weight: bold;">$${totalAmount}</td>
    </tr>
</table>

</body>
</html>
