package com.example.module3casestudy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hostel_booking_system_c10";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "@Chuanhquan1211z";

    // Sử dụng Singleton để đảm bảo chỉ có một instance của Connection
    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Database connection error", e);
        }
        return connection;
    }
}