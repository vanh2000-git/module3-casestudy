package com.example.module3casestudy.service.bookingAd;

import com.example.module3casestudy.eNum.BookingStatusENum;
import com.example.module3casestudy.model.Bookings;
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
    public List<Bookings> getAllBookings() {
        List<Bookings> bookingsList = new ArrayList<>();
        String sql = "SELECT * FROM bookings";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                bookingsList.add(mapResultSetToBooking(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookingsList;
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

    @Override
    public List<Bookings> getConfirmedBookings() {
        List<Bookings> confirmedBookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE status = 'confirmed'";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                confirmedBookings.add(mapResultSetToBooking(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return confirmedBookings;
    }

    @Override
    public double getTotalRevenue() {
        String sql = "SELECT SUM(total_amount) FROM bookings WHERE status = 'completed'";
        double totalRevenue = 0;

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                totalRevenue = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRevenue;
    }

    @Override
    public Bookings getBookingById(int bookingId) {
        String sql = "SELECT * FROM bookings WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Bookings(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("room_id"),
                        rs.getDate("check_in").toLocalDate(),
                        rs.getDate("check_out").toLocalDate(),
                        BookingStatusENum.valueOf(rs.getString("status")),
                        rs.getDouble("total_amount")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Bookings mapResultSetToBooking(ResultSet rs) throws SQLException {
        return new Bookings(
                rs.getInt("id"),
                rs.getInt("user_id"),
                rs.getInt("room_id"),
                rs.getDate("check_in").toLocalDate(),
                rs.getDate("check_out").toLocalDate(),
                BookingStatusENum.valueOf(rs.getString("status")),
                rs.getDouble("total_amount")
        );
    }

}