<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        input, select, button {
            display: block;
            width: 100%;
            padding: 10px;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Book a Room</h2>
    <%
        String userId = request.getParameter("userId");
        String roomId = request.getParameter("roomId");
    %>

    <form action="customerBooking" method="post">
        <input type="hidden" name="userId" value="<%= userId %>">

        <label>Room ID: <%= roomId %>"</label>
        <br>
<%--        <input type="number" id="roomId" name="roomId value="<%= roomId %>">--%>
        <input type="hidden" name="roomId" value="<%= roomId %>">
        <label for="checkIn">Check-in Date:</label>
        <input type="date" id="checkIn" name="checkIn" required>

        <label for="checkOut">Check-out Date:</label>
        <input type="date" id="checkOut" name="checkOut" required>

        <label for="totalAmount">Total Amount:</label>
        <input type="number" id="totalAmount" name="totalAmount" step="0.01" required>

        <button type="submit">Book Now</button>
    </form>
</div>
</body>
</html>
