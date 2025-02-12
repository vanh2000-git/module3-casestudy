package com.example.module3casestudy.controller.bookingAD;

import com.example.module3casestudy.dto.BookingDTO;
import com.example.module3casestudy.eNum.BookingStatusENum;
import com.example.module3casestudy.model.Bookings;
import com.example.module3casestudy.service.bookingAd.BookingDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "bookinghistory", value = "/history_booking")
public class BookingAdServlet extends HttpServlet {
    private BookingDAOImpl bookingDAO = new BookingDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String location = request.getParameter("location");
        String status = request.getParameter("status");

        List<BookingDTO> bookings = bookingDAO.getFilteredBookings(location, status);
        List<String> locations = bookingDAO.getAllLocations();
        List<String> statuses = bookingDAO.getAllStatuses();
        double totalAmount = bookingDAO.getTotalAmount(bookings);

        request.setAttribute("totalAmount", totalAmount);
        request.setAttribute("bookings", bookings);
        request.setAttribute("locations", locations);
        request.setAttribute("statuses", statuses);
        request.getRequestDispatcher("/BookingAD/bookingHistory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        String status = request.getParameter("status");

        boolean isUpdated = bookingDAO.updateStatus(bookingId, BookingStatusENum.valueOf(status));

        HttpSession session = request.getSession();
        if (isUpdated) {
            session.setAttribute("message", "Cập nhật trạng thái thành công!");
        } else {
            session.setAttribute("error", "Cập nhật trạng thái thất bại!");
        }

        response.sendRedirect("history_booking");
    }
}
