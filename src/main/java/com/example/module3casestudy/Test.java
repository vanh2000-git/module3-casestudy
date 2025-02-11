package com.example.module3casestudy;

import com.example.module3casestudy.eNum.BookingStatusENum;
import com.example.module3casestudy.eNum.RoomLocationE;
import com.example.module3casestudy.eNum.RoomStatusENum;
import com.example.module3casestudy.model.Bookings;
import com.example.module3casestudy.model.Reviews;
import com.example.module3casestudy.model.Rooms;
import com.example.module3casestudy.model.Users;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Users users = new Users(1, "dung", "0123123123", "hihi", "11");
        Users users2 = new Users(2, "SON", "0123123123", "hihi", "11");
        Users users3 = new Users(3, "QUAN", "0123123123", "hihi", "11");

        Rooms room1 = new Rooms(1, "Room A", "Nice view", RoomLocationE.caugiay, 100.0, "roomA.jpg");
        Rooms room2 = new Rooms(2, "Room B", "City center", RoomLocationE.hadong, 150.0, "roomB.jpg");
        Rooms room3 = new Rooms(3, "Room C", "Sea view", RoomLocationE.thanhxuan, 200.0, "roomC.jpg");

        List<Bookings> bookingsList = Arrays.asList(
                new Bookings(1, users.getId(), room1.getId(), LocalDate.of(2025, 3, 1), LocalDate.of(2025, 3, 5), BookingStatusENum.confirmed, room1.getPrice() * 4),
                new Bookings(2, users2.getId(), room2.getId(), LocalDate.of(2025, 4, 10), LocalDate.of(2025, 4, 15),BookingStatusENum.canceled, room2.getPrice() * 5),
                new Bookings(3, users3.getId(), room3.getId(), LocalDate.of(2025, 5, 20), LocalDate.of(2025, 5, 25),BookingStatusENum.canceled, room3.getPrice() * 5)
        );

        for (Bookings booking : bookingsList) {
            System.out.println(booking);
        }
        Bookings booking1 = bookingsList.get(0);
//        booking1.setStatus(BookingStatusENum.completed);
        System.out.println(booking1.getStatus());

        if (booking1.getStatus() == BookingStatusENum.completed) {
            Reviews review1 = new Reviews(1, booking1.getId(), "Great room, very clean!");
            System.out.println("Review added: " + review1.getDetail());
        } else {
            System.out.println("Cannot review. Booking is not completed.");
        }
    }
}
