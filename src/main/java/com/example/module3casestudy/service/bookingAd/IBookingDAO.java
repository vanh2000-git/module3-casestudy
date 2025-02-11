package com.example.module3casestudy.service.bookingAd;

import com.example.module3casestudy.dto.BookingDTO;
import com.example.module3casestudy.eNum.BookingStatusENum;
import com.example.module3casestudy.model.Bookings;

import java.util.List;

public interface IBookingDAO {
    List<BookingDTO> getAllBookings();

    boolean updateStatus(int bookingId, BookingStatusENum status);

    List<BookingDTO> getConfirmedBookings();

    double getTotalRevenue();

    Bookings getBookingById(int bookingId);
}
