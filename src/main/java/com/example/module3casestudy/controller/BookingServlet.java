package com.example.module3casestudy.controller;

import com.example.module3casestudy.model.Bookings;
import com.example.module3casestudy.service.BookingService;
import com.example.module3casestudy.service.IBookingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "customerBooking", value = "/customerBooking")
public class BookingServlet extends HttpServlet {
    IBookingService bookingService = new BookingService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        String checkIn = req.getParameter("checkIn");
        String checkOut = req.getParameter("checkOut");
        double totalAmount = Double.parseDouble(req.getParameter("totalAmount"));
        boolean success = bookingService.createBooking(userId, roomId, checkIn, checkOut, totalAmount);
        if (success) {
            resp.sendRedirect("booking-pending.jsp");
        } else {
            resp.sendRedirect("booking-failed.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Bookings> bookings = bookingService.getAllBookings();
        req.setAttribute("bookings", bookings);
        req.getRequestDispatcher("bookings.jsp").forward(req, resp);
    }
}


