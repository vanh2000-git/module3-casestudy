package com.example.module3casestudy.service;

import com.example.module3casestudy.model.Bookings;

import java.util.List;
import java.util.Map;

public interface IBookingService {
    public boolean createBooking(int userId, int roomId, String checkIn, String checkOut, double totalAmount);
    public boolean cancelBooking(int bookingId);
    List<Bookings> getAllBookings(int user_id);
    public List<Map<String, Object>> getAllBookingsWithDetails(int userId);
}
