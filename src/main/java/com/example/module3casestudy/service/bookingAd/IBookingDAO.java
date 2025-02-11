package com.example.module3casestudy.service.bookingAd;

import com.example.module3casestudy.eNum.BookingStatusENum;
import com.example.module3casestudy.model.Bookings;

import java.util.List;

public interface IBookingDAO {
    List<Bookings> getAllBookings();

    boolean updateStatus(int bookingId, BookingStatusENum status);

    List<Bookings> getConfirmedBookings();

    double getTotalRevenue();

    Bookings getBookingById(int bookingId);
}
