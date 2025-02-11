package com.example.module3casestudy;

import com.example.module3casestudy.eNum.BookingStatusENum;
import com.example.module3casestudy.model.Bookings;
import com.example.module3casestudy.service.bookingAd.BookingDAOImpl;
import com.example.module3casestudy.service.bookingAd.IBookingDAO;

import java.util.List;

public class TestBooking {
    public static void main(String[] args) {
        IBookingDAO bookingDAO = new BookingDAOImpl();

        // Test getAllBookings()
        System.out.println("Danh sách tất cả booking:");
        List<Bookings> allBookings = bookingDAO.getAllBookings();
        for (Bookings booking : allBookings) {
            System.out.println(booking);
        }

        // Test updateStatus()
        int bookingId = 1; // Giả sử có booking ID = 1 trong database
        boolean isUpdated = bookingDAO.updateStatus(bookingId, BookingStatusENum.canceled);
        System.out.println("Cập nhật trạng thái booking ID " + bookingId + ": " + (isUpdated ? "Thành công" : "Thất bại"));

        Bookings booking = bookingDAO.getBookingById(bookingId);
        if (booking != null) {
            System.out.println("Thông tin booking ID " + bookingId + ": " + booking);
        } else {
            System.out.println("Không tìm thấy booking ID " + bookingId);
        }

        // Test getConfirmedBookings()
        System.out.println("\nDanh sách các booking đã xác nhận:");
        List<Bookings> confirmedBookings = bookingDAO.getConfirmedBookings();
        for (Bookings bookings : confirmedBookings) {
            System.out.println(bookings);
        }

        // Test getTotalRevenue()
        double totalRevenue = bookingDAO.getTotalRevenue();
        System.out.println("\nTổng doanh thu: " + totalRevenue);
    }
}
