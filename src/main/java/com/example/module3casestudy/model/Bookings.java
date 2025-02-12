package com.example.module3casestudy.model;

import com.example.module3casestudy.eNum.BookingStatusENum;

import java.time.LocalDate;

public class Bookings {
    private int id;
    private int user_id;
    private int room_id;
    private LocalDate check_in;
    private LocalDate check_out;
    BookingStatusENum status;
    private double total_amount;

    public Bookings(int id, int user_id, int room_id, LocalDate check_in, LocalDate check_out,BookingStatusENum status, double total_amount) {
        this.id = id;
        this.user_id = user_id;
        this.room_id = room_id;
        this.check_in = check_in;
        this.check_out = check_out;
        this.status = status;
        this.total_amount = total_amount;
    }

    public Bookings(int id, int userId, int roomId, LocalDate checkIn, LocalDate checkOut, String bookingStatus, double totalAmount) {
        this.status = BookingStatusENum.pending;
    }

    public Bookings(int user_id, int room_id, LocalDate check_in, LocalDate check_out, BookingStatusENum status, double total_amount) {
        this.user_id = user_id;
        this.room_id = room_id;
        this.check_in = check_in;
        this.check_out = check_out;
        this.status = status;
        this.total_amount = total_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public LocalDate getCheck_in() {
        return check_in;
    }

    public void setCheck_in(LocalDate check_in) {
        this.check_in = check_in;
    }

    public LocalDate getCheck_out() {
        return check_out;
    }

    public void setCheck_out(LocalDate check_out) {
        this.check_out = check_out;
    }

    public BookingStatusENum getStatus() {
        return status;
    }

    public void setStatus(BookingStatusENum status) {
        this.status = status;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", room_id=" + room_id +
                ", check_in=" + check_in +
                ", check_out=" + check_out +
                ", status=" + status +
                ", total_amount=" + total_amount +
                '}';
    }
}
