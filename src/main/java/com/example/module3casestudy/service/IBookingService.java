package com.example.module3casestudy.service;

import com.example.module3casestudy.model.Bookings;

import java.util.List;

public interface IBookingService {
    public boolean createBooking(int userId, int roomId, String checkIn, String checkOut, double totalAmount);
    public boolean cancelBooking(int bookingId);
    List<Bookings> getAllBookings(int user_id);
}
