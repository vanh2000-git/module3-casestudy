<%--
  Created by IntelliJ IDEA.
  User: dungn
  Date: 2/11/2025
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
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
    </style>
</head>
<body>

<h2>Lịch sử Booking</h2>
<h2>User List ${bookings.size()}</h2>

<table>
    <tr>
        <th>ID</th>
        <th>User ID</th>
        <th>Room ID</th>
        <th>Check-in</th>
        <th>Check-out</th>
        <th>Status</th>
        <th>Total Amount</th>
    </tr>
    <c:forEach items="${bookings}" var="booking">
    <tr>
        <td>${booking.getId()}</td>
        <td>${booking.getUser_id()}</td>
        <td>${booking.getRoom_id()}</td>
        <td>${booking.setCheck_in()}</td>
        <td>${booking.getCheck_out()}</td>
        <td>${booking.getStatus()}</td>
        <td>$${booking.getTotal_amount()}</td>
    </tr>
    </c:forEach>
</table>

</body>
</html>

