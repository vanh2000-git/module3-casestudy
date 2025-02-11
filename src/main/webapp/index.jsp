<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giao Diện Website</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Thêm CSS tùy chỉnh */
        body {
            background-color: #f8f9fa;
        }

        .navbar {
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .login-modal .modal-content,
        .register-modal .modal-content {
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
        }

        .btn-primary-custom {
            background-color: #007bff;
            border: none;
            transition: 0.3s;
        }

        .btn-primary-custom:hover {
            background-color: #0056b3;
        }

        .hero {
            background: linear-gradient(135deg, #007bff, #00c6ff);
            color: white;
            padding: 60px 0;
            text-align: center;
            border-radius: 0 0 30px 30px;
        }

        .hero h1 {
            font-size: 3rem;
            font-weight: bold;
        }

        #carouselExampleRide {
            height: 600px;
            overflow: hidden;
        }

        /* Đảm bảo hình ảnh không bị biến dạng */
        #carouselExampleRide img {
            height: 600px;
            object-fit: cover;
        }
    </style>
</head>
<body>

<!-- Header / Navbar -->
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
                    <a class="nav-link" href="#">Room</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
            </ul>
            <button class="btn btn-primary-custom ms-3" data-bs-toggle="modal" data-bs-target="#loginModal">Đăng Nhập</button>
        </div>
    </div>
</nav>
<div id="carouselExampleRide" class="carousel slide" data-bs-ride="carousel" data-bs-interval="1500">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="/img/anhso1.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="/img/anhso2.png" alt="...">
        </div>
        <div class="carousel-item">
            <img src="/img/anhso3.png" class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>




<!-- Hero Section -->
<div class="hero">
    <div class="container">

    </div>
</div>

<!-- Nội dung chính -->
<div class="container mt-5">
    <div class="row">
        <div class="col-md-6">
            <h2>Giới thiệu về chúng tôi</h2>
            <p>Chúng tôi chuyên cung cấp dịch vụ cho thuê phòng chất lượng, đáp ứng mọi nhu cầu của bạn. Với các loại phòng đa dạng, tiện nghi hiện đại và vị trí thuận lợi, chúng tôi cam kết mang đến cho bạn không gian sống thoải mái, an toàn và phù hợp nhất.</p>
        </div>
        <div class="col-md-6">
            <img src="/img/anhso4.jpg" class="img-fluid rounded" alt="Placeholder Image">
        </div>
    </div>
</div>

<!-- Modal Đăng Nhập -->
<div class="modal fade login-modal" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="loginModalLabel">Đăng Nhập</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
                        <label for="login-username" class="form-label">Tên đăng nhập</label>
                        <input type="text" class="form-control" id="login-username" placeholder="Nhập tên đăng nhập">
                    </div>
                    <div class="mb-3">
                        <label for="login-password" class="form-label">Mật khẩu</label>
                        <input type="password" class="form-control" id="login-password" placeholder="Nhập mật khẩu">
                    </div>
                    <button type="button" class="btn btn-primary-custom w-100" id="submitLogin">Đăng Nhập</button>
                    <p class="text-center mt-3">
                        Chưa có tài khoản? <a href="#" data-bs-dismiss="modal" data-bs-toggle="modal" data-bs-target="#registerModal">Đăng ký ngay</a>
                    </p>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Modal Đăng Ký -->
<div class="modal fade register-modal" id="registerModal" tabindex="-1" aria-labelledby="registerModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="registerModalLabel">Đăng Ký</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
                        <label for="register-username" class="form-label">Tên đăng nhập</label>
                        <input type="text" class="form-control" id="register-username" placeholder="Nhập tên đăng nhập">
                    </div>
                    <div class="mb-3">
                        <label for="register-email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="register-email" placeholder="Nhập email">
                    </div>
                    <div class="mb-3">
                        <label for="register-password" class="form-label">Mật khẩu</label>
                        <input type="password" class="form-control" id="register-password" placeholder="Nhập mật khẩu">
                    </div>
                    <button type="button" class="btn btn-primary-custom w-100" id="submitRegister">Đăng Ký</button>
                </form>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>

<script>
    // Xử lý đăng nhập
    document.getElementById("submitLogin").addEventListener("click", function () {
        const username = document.getElementById("login-username").value;
        const password = document.getElementById("login-password").value;

        // Kiểm tra điều kiện đăng nhập (giả lập)
        if (username === "admin" && password === "1234") {
            alert("Đăng nhập thành công!");
            const loginButton = document.querySelector(".btn-primary-custom[data-bs-target='#loginModal']");
            loginButton.textContent = "Xin chào, Admin!";
            loginButton.disabled = true;
            loginButton.style.backgroundColor = "#6c757d";

            // Ẩn modal
            const loginModal = document.getElementById("loginModal");
            const modalInstance = bootstrap.Modal.getInstance(loginModal);
            modalInstance.hide();
        } else {
            alert("Tên đăng nhập hoặc mật khẩu không đúng!");
        }
    });

    // Xử lý đăng ký (giả lập)
    document.getElementById("submitRegister").addEventListener("click", function () {
        const username = document.getElementById("register-username").value;
        const email = document.getElementById("register-email").value;
        const password = document.getElementById("register-password").value;

        if (username && email && password) {
            alert("Đăng ký thành công! Bạn có thể đăng nhập ngay.");
            const registerModal = document.getElementById("registerModal");
            const modalInstance = bootstrap.Modal.getInstance(registerModal);
            modalInstance.hide();
        } else {
            alert("Vui lòng điền đầy đủ thông tin.");
        }
    });
</script>
</body>
</html>
