package com.example.module3casestudy.dto;

import com.example.module3casestudy.eNum.BookingStatusENum;

import java.time.LocalDate;

public class BookingDTO {
    private int bookingId;
    private String customerName;
    private String customerPhone;
    private String roomName;
    private String roomLocation;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private BookingStatusENum bookingStatus;
    private double totalAmount;

    public BookingDTO(int bookingId, String customerName, String customerPhone, String roomName, String roomLocation, LocalDate checkIn, LocalDate checkOut, BookingStatusENum bookingStatus, double totalAmount) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.roomName = roomName;
        this.roomLocation = roomLocation;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingStatus = bookingStatus;
        this.totalAmount = totalAmount;
    }

    public BookingDTO() {
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomLocation() {
        return roomLocation;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public BookingStatusENum getBookingStatus() {
        return bookingStatus;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public void setBookingStatus(BookingStatusENum bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
