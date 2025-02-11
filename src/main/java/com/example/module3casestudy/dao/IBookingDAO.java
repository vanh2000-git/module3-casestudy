package com.example.module3casestudy.dao;

import com.example.module3casestudy.model.Bookings;

import java.util.List;

public interface IBookingDAO {
    List<Bookings> getAllBookings();

    boolean updateStatus(int bookingId, String status);

    List<Bookings> getConfirmedBookings();

    double getTotalRevenue();
}
