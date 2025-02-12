package com.example.module3casestudy.service.bookingAd;

import com.example.module3casestudy.dto.BookingDTO;
import com.example.module3casestudy.eNum.BookingStatusENum;
import com.example.module3casestudy.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl implements IBookingDAO {
    private final Connection connection;

    public BookingDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean updateStatus(int bookingId, BookingStatusENum status) {
        String sql = "UPDATE bookings SET status = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, String.valueOf(status));
            stmt.setInt(2, bookingId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private BookingDTO mapResultSetToBookingDTO(ResultSet rs) throws SQLException {
        BookingDTO booking = new BookingDTO();
        booking.setBookingId(rs.getInt("booking_id"));
        booking.setCustomerName(rs.getString("customer_name"));
        booking.setCustomerPhone(rs.getString("customer_phone"));
        booking.setRoomName(rs.getString("room_name"));
        booking.setRoomLocation(rs.getString("room_location"));
        booking.setCheckIn(rs.getDate("check_in").toLocalDate());
        booking.setCheckOut(rs.getDate("check_out").toLocalDate());
        booking.setBookingStatus(BookingStatusENum.valueOf(rs.getString("booking_status").toLowerCase()));
        booking.setTotalAmount(rs.getDouble("total_amount"));
        return booking;
    }

    @Override
    public List<BookingDTO> getFilteredBookings(String location, String status) {
        List<BookingDTO> bookings = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM admin_booking_review WHERE 1=1");

        if (location != null && !location.isEmpty()) {
            sql.append(" AND room_location = ?");
        }
        if (status != null && !status.isEmpty()) {
            sql.append(" AND booking_status = ?");
        }
        sql.append(" ORDER BY check_in DESC");

        try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
            int paramIndex = 1;
            if (location != null && !location.isEmpty()) {
                stmt.setString(paramIndex++, location);
            }
            if (status != null && !status.isEmpty()) {
                stmt.setString(paramIndex++, status);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bookings.add(mapResultSetToBookingDTO(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    @Override
    public List<String> getAllLocations() {
        List<String> locations = new ArrayList<>();
        String sql = "SELECT DISTINCT room_location FROM admin_booking_review";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                locations.add(rs.getString("room_location"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }

    @Override
    public List<String> getAllStatuses() {
        List<String> statuses = new ArrayList<>();
        String sql = "SELECT DISTINCT booking_status FROM admin_booking_review";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                statuses.add(rs.getString("booking_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }

    @Override
    public double getTotalAmount(List<BookingDTO> bookings) {
        return bookings.stream().mapToDouble(BookingDTO::getTotalAmount).sum();
    }
}