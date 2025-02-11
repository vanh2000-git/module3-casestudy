package com.example.module3casestudy.model;

public class Reviews {
private int id;
private int booking_id;
private String detail;

    public Reviews() {
    }

    public Reviews(int id, int booking_id, String detail) {
        this.id = id;
        this.booking_id = booking_id;
        this.detail = detail;
    }

    public Reviews(int booking_id, String detail) {
        this.booking_id = booking_id;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
