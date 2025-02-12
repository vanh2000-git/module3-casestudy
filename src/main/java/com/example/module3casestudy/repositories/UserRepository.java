package com.example.module3casestudy.repositories;

import com.example.module3casestudy.eNum.UserEnum;
import com.example.module3casestudy.model.Users;
import com.example.module3casestudy.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UserRepository implements IUserRepository {
    @Override
    public String InsertUser(Users user) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = null;

            String query = "INSERT INTO users(name, phone, password, img) values(?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getImage());

           int result = preparedStatement.executeUpdate();

           if(result > 0) {
               return user.getPhone();
           } else {
               throw new RuntimeException("Insert thất bại");
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Users GetUserByPhone(String phone) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = null;

            String query = "SELECT * FROM users where phone = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) { // Nếu có dữ liệu
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone");
                String password = resultSet.getString("password");
                String image = resultSet.getString("img");
                String role = resultSet.getString("role");

                Users user = new Users(id, name, phoneNumber, password, image);

                if(Objects.equals(role, "admin")) {
                    user.setRole(UserEnum.admin);
                } else {
                    user.setRole(UserEnum.customer);
                }

                return user;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean ValidateUser(String phone, String password) {
        Users user = GetUserByPhone(phone);

        if(Objects.equals(user.getPhone(), phone)){
            return Objects.equals(user.getPassword(), password);
        }
        return false;
    }

    @Override
    public UserEnum GetRoleOfUser(String phone) {
        Users user = GetUserByPhone(phone);
        return user.getRole();
    }


}
