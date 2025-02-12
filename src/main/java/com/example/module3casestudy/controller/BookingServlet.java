package com.example.module3casestudy.controller;

import com.example.module3casestudy.model.Bookings;
import com.example.module3casestudy.service.BookingService;
import com.example.module3casestudy.service.IBookingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "customerBooking", value = "/customerBooking")
public class BookingServlet extends HttpServlet {
    IBookingService bookingService = new BookingService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String userIdParam = req.getParameter("userId");

        if (userIdParam == null || userIdParam.isEmpty()) {
            req.setAttribute("error", "❌ Lỗi: User ID không hợp lệ!");
            req.getRequestDispatcher("error-page.jsp").forward(req, resp);
            return;
        }

        int userId = Integer.parseInt(userIdParam); // Parse userId khi hợp lệ

        if ("cancel".equals(action)) {
            int bookingId = Integer.parseInt(req.getParameter("bookingId"));
            boolean success = bookingService.cancelBooking(bookingId);

            if (!success) {
                req.setAttribute("error", "❌ Hủy đặt phòng thất bại! Chỉ có thể hủy đơn đặt đang chờ xử lý.");
            }

        } else {
            int roomId = Integer.parseInt(req.getParameter("roomId"));
            String checkIn = req.getParameter("checkIn");
            String checkOut = req.getParameter("checkOut");
            double totalAmount = Double.parseDouble(req.getParameter("totalAmount"));

            boolean success = bookingService.createBooking(userId, roomId, checkIn, checkOut, totalAmount);

            if (!success) {
                req.setAttribute("error", "❌ Đặt phòng thất bại! Vui lòng thử lại.");
            }
        }

        // ✅ Sau khi xử lý, chuyển về trang danh sách đặt phòng
        resp.sendRedirect("customerBooking?userId=" + userId);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String para = req.getParameter("userId");

        if (para != null && !para.isEmpty()) {
            int userId = Integer.parseInt(para);



            List<Bookings> bookings = bookingService.getAllBookings(userId);

            req.setAttribute("bookings", bookings);
            req.setAttribute("userId", userId);

            req.getRequestDispatcher("bookings.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("booking-form.jsp").forward(req, resp);
        }
    }

}


