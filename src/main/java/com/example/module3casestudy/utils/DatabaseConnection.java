package com.example.module3casestudy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                String url = ConfigReader.getProperty("db.url");
                String username = ConfigReader.getProperty("db.username");
                String password = ConfigReader.getProperty("db.password");

                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Database connection error", e);
        }
        return connection;
    }
}