<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đặt Phòng</title>
    <!-- Bootstrap CSS -->
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
                    <a class="nav-link" href="customerBooking?userId=${userId}">Đơn Đã Đặt</a>
                </li>
                <li class="nav-item ms-3">
                    <span class="user-badge">${userName}</span>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Booking Form -->
<div class="container">
    <div class="booking-container">
        <h2 class="text-center text-primary">Đặt Phòng</h2>
        <p class="text-center text-muted">Vui lòng nhập thông tin để hoàn tất đặt phòng</p>

        <form action="customerBooking" method="post">
            <input type="hidden" name="userId" value="${param.userId}">
            <input type="hidden" name="roomId" value="${param.roomId}">
            <input type="hidden" id="roomPrice" value="${param.roomPrice}">

            <div class="mb-3">
                <h5 class="fw-bold">Bạn đang đặt phòng ID: ${param.roomId}</h5>
                <p class="text-danger fw-bold">Giá phòng: ${param.roomPrice} VNĐ / đêm</p>
            </div>

            <div class="mb-3">
                <label for="checkIn" class="form-label">Ngày nhận phòng:</label>
                <input type="date" id="checkIn" name="checkIn" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="checkOut" class="form-label">Ngày trả phòng:</label>
                <input type="date" id="checkOut" name="checkOut" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Tổng tiền:</label>
                <input type="hidden" id="totalAmount" name="totalAmount" value="0">
                <p class="fw-bold text-danger" id="totalAmountDisplay">0 VNĐ</p>
            </div>

            <button type="submit" class="btn btn-primary-custom w-100">Đặt ngay</button>
        </form>

        <div class="text-center mt-3">
            <button onclick="history.back()" class="btn btn-secondary">⬅ Quay lại</button>
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

<script>
    function calculateTotal() {
        let checkIn = new Date(document.getElementById("checkIn").value);
        let checkOut = new Date(document.getElementById("checkOut").value);
        let roomPrice = parseFloat(document.getElementById("roomPrice").value) || 0;

        if (!isNaN(checkIn) && !isNaN(checkOut) && checkOut > checkIn) {
            let days = Math.ceil((checkOut - checkIn) / (1000 * 60 * 60 * 24));
            let total = days * roomPrice;

            // Gán giá trị số vào input (để gửi về server)
            document.getElementById("totalAmount").value = total;

            // Hiển thị số tiền có định dạng VNĐ
            document.getElementById("totalAmountDisplay").innerText = new Intl.NumberFormat('vi-VN').format(total) + " VNĐ";
        } else {
            document.getElementById("totalAmount").value = 0;
            document.getElementById("totalAmountDisplay").innerText = "0 VNĐ";
        }
    }

    document.getElementById("checkIn").addEventListener("change", calculateTotal);
    document.getElementById("checkOut").addEventListener("change", calculateTotal);
</script>

</body>
</html>
