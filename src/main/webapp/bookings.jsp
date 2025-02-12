<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Danh Sách Đặt Phòng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .booking-container {
            max-width: 500px;
            margin: 80px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        .btn-primary-custom {
            background-color: #007bff;
            border: none;
            transition: all 0.3s ease-in-out;
        }

        .btn-primary-custom:hover {
            background-color: #0056b3;
        }

        .navbar {
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .user-badge {
            background-color: #dc3545;
            color: white;
            font-weight: bold;
            padding: 8px 15px;
            border-radius: 20px;
        }
        .table thead {
            background-color: #007bff;
            color: white;
        }
        .table-hover tbody tr:hover {
            background-color: #f1f1f1;
        }
        .status-pending {
            color: #ffc107;
            font-weight: bold;
        }
        .status-confirmed {
            color: #28a745;
            font-weight: bold;
        }
        .status-cancelled {
            color: #dc3545;
            font-weight: bold;
        }
    </style>
</head>
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
                    <a class="nav-link" href="customerBooking?userId=${userId}">Đơn Đã Đặt</a>
                </li>
                <li class="nav-item ms-3">
                    <span class="user-badge">${userName}</span>
                </li>
            </ul>
        </div>
    </div>
</nav>
<body class="bg-light">

<div class="container mt-5">
    <h1 class="text-center mb-4">Danh Sách Đặt Phòng (${bookings.size()} đơn)</h1>

    <table class="table table-bordered table-hover text-center">
        <thead>
        <tr>
            <th>ID</th>
            <th>Khách hàng</th>
            <th>Phòng</th>
            <th>Check-in</th>
            <th>Check-out</th>
            <th>Trạng thái</th>
            <th class="text-end">Tổng tiền</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookings}" var="b">
            <tr>
                <td>${b.id}</td>
                <td>${b.user_name}</td>
                <td>${b.room_name}</td>
                <td>${b.check_in}</td>
                <td>${b.check_out}</td>
                <td>
                        <span class="${b.status == 'pending' ? 'status-pending' : (b.status == 'confirmed' ? 'status-confirmed' : 'status-cancelled')}">
                                ${b.status}
                        </span>
                </td>
                <td class="text-end">${b.total_amount} VNĐ</td>
                <td>
                    <c:if test="${b.status == 'pending'}">
                        <form action="customerBooking" method="post" class="d-inline">
                            <input type="hidden" name="action" value="cancel">
                            <input type="hidden" name="bookingId" value="${b.id}">
                            <input type="hidden" name="userId" value="${userId}">
                            <button type="submit" class="btn btn-danger btn-sm">Hủy Đặt</button>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Nút quay lại -->
    <div class="text-center mt-4">
        <button class="btn btn-secondary" onclick="goBack()">⬅ Quay lại danh sách phòng</button>
    </div>
</div>

<footer class="bg-white mt-5 py-3">
    <div class="container text-center">
        <p class="mb-0">&copy; 2025 - C1024G1. Tất cả các quyền được bảo lưu.</p>
    </div>
</footer>

<script>
    function goBack() {
        if (document.referrer.includes("roomlist")) {
            history.back();
        } else {
            window.location.href = "roomlist";
        }
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
