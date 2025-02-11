<%--
  Created by IntelliJ IDEA.
  User: dungn
  Date: 2/11/2025
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <tr>
        <td>1</td>
        <td>101</td>
        <td>202</td>
        <td>2025-02-01</td>
        <td>2025-02-05</td>
        <td>Confirmed</td>
        <td>$500</td>
    </tr>
    <tr>
        <td>2</td>
        <td>102</td>
        <td>205</td>
        <td>2025-02-10</td>
        <td>2025-02-15</td>
        <td>Pending</td>
        <td>$750</td>
    </tr>
</table>

</body>
</html>

