<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Danh Sách Đặt Phòng</title>
</head>
<body>
<h1>Danh Sách Đặt Phòng (${bookings.size()} đơn)</h1>
<c:if test="${not empty error}">
    <div style="color: red; font-weight: bold;">${error}</div>
</c:if>
<table border="1">
    <tr>
        <th>ID</th>
        <th>User ID</th>
        <th>Room ID</th>
        <th>Check-in</th>
        <th>Check-out</th>
        <th>Trạng thái</th>
        <th>Tổng tiền</th>
        <th>Hành động</th>
    </tr>
    <c:forEach items="${bookings}" var="b">
        <tr>
            <td>${b.id}</td>
            <td>${b.user_id}</td>
            <td>${b.room_id}</td>
            <td>${b.check_in}</td>
            <td>${b.check_out}</td>
            <td>${b.status}</td>
            <td>${b.total_amount}</td>
            <td>
                <c:if test="${b.status.name() == 'pending'}">
                    <form action="customerBooking" method="post">
                        <input type="hidden" name="action" value="cancel">
                        <input type="hidden" name="bookingId" value="${b.id}">
                        <input type="hidden" name="userId" value="${userId}">
                        <button type="submit">Hủy Đặt</button>
                    </form>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
