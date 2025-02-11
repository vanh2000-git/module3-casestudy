package com.example.module3casestudy;

import com.example.module3casestudy.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTest {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null) {
                System.out.println("✅ Kết nối cơ sở dữ liệu thành công!");

                // Tạo truy vấn SQL
                String query = "SELECT id, name, phone, role FROM users";

                // Tạo Statement và thực thi truy vấn
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                // Hiển thị kết quả
                System.out.println("Danh sách người dùng:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String role = rs.getString("role");

                    System.out.println("ID: " + id + ", Name: " + name + ", Phone: " + phone + ", Role: " + role);
                }

                // Đóng tài nguyên
                rs.close();
                stmt.close();
                conn.close();
            } else {
                System.out.println("❌ Kết nối thất bại!");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi truy vấn SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi kết nối: " + e.getMessage());
        }
    }
}
