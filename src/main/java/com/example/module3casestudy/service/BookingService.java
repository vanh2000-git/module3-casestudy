package com.example.module3casestudy.service;

import com.example.module3casestudy.eNum.BookingStatusENum;
import com.example.module3casestudy.model.Bookings;
import com.example.module3casestudy.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService implements IBookingService {
    private final Connection connection;

    public BookingService() {
        this.connection = DatabaseConnection.getConnection();
    }

    public boolean createBooking(int userId, int roomId, String checkIn, String checkOut, double totalAmount) {
        String sql = "INSERT INTO bookings (user_id, room_id, check_in, check_out, status, total_amount) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, roomId);
            stmt.setString(3, checkIn);
            stmt.setString(4, checkOut);
            stmt.setString(5, BookingStatusENum.pending.name());
            stmt.setDouble(6, totalAmount);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean cancelBooking(int bookingId) {
        String sql = "UPDATE bookings SET status = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, BookingStatusENum.canceled.name());
            stmt.setInt(2, bookingId);

            return stmt.executeUpdate() > 0; // Trả về true nếu có bản ghi bị ảnh hưởng
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Map<String, Object>> getAllBookingsWithDetails(int userId) {
        List<Map<String, Object>> results = new ArrayList<>();
        String sql = "SELECT b.id, b.check_in, b.check_out, b.status, b.total_amount, " +
                "u.name AS user_name, r.name AS room_name " +
                "FROM bookings b " +
                "JOIN users u ON b.user_id = u.id " +
                "JOIN rooms r ON b.room_id = r.id " +
                "WHERE b.user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> bookingData = new HashMap<>();
                bookingData.put("id", rs.getInt("id"));
                bookingData.put("check_in", rs.getDate("check_in"));
                bookingData.put("check_out", rs.getDate("check_out"));
                bookingData.put("status", rs.getString("status"));
                bookingData.put("total_amount", rs.getDouble("total_amount"));
                bookingData.put("user_name", rs.getString("user_name"));
                bookingData.put("room_name", rs.getString("room_name"));
                results.add(bookingData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


    @Override
    public List<Bookings> getAllBookings(int user_id) {
        List<Bookings> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE user_id = ?";

        System.out.println("🔍 Đang thực hiện truy vấn: " + sql + " với user_id = " + user_id);

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, user_id); // Đặt tham số trước khi thực thi
            try (ResultSet rs = stmt.executeQuery()) { // Đóng ResultSet sau khi dùng
                while (rs.next()) {
                    Bookings booking = new Bookings(
                            rs.getInt("id"),
                            rs.getInt("user_id"),
                            rs.getInt("room_id"),
                            rs.getDate("check_in").toLocalDate(),
                            rs.getDate("check_out").toLocalDate(),
                            BookingStatusENum.valueOf(rs.getString("status").toLowerCase()),
                            rs.getDouble("total_amount")
                    );
                    bookings.add(booking);
                    System.out.println("✅ Lấy dữ liệu: " + booking);
                }
            }

            System.out.println("📋 Tổng số bookings lấy được: " + bookings.size());

        } catch (SQLException e) {
            System.err.println("❌ Lỗi truy vấn SQL: " + e.getMessage());
            e.printStackTrace();
        }
        return bookings;
    }

}
