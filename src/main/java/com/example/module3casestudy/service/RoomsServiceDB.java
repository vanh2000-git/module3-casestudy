package com.example.module3casestudy.service;

import com.example.module3casestudy.eNum.RoomStatusENum;
import com.example.module3casestudy.model.Rooms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.module3casestudy.utils.DatabaseConnection.getConnection;

public class RoomsServiceDB implements IRoomsService {
    @Override
    public List<Rooms> findAll() throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from rooms;");
        ResultSet resultSet = statement.executeQuery();

        List<Rooms> rooms = new ArrayList<>();
        while (resultSet.next()) {
            Rooms room = new Rooms();
            room.setId(resultSet.getInt("id"));
            room.setName(resultSet.getString("name"));
            room.setDescription(resultSet.getString("description"));
            room.setLocation(resultSet.getString("location"));
            room.setPrice(resultSet.getDouble("price"));
            room.setImg(resultSet.getString("img"));
            room.setStatus(RoomStatusENum.valueOf(resultSet.getString("status")));
            rooms.add(room);
        }
        return rooms;
    }

    @Override
    public void create(Rooms room) {
    }

    @Override
    public void save(Rooms room) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        preparedStatement = connection.prepareStatement("INSERT INTO rooms (name, description, location, price, img, status) VALUES (?,?,?,?,?,?);");

        preparedStatement.setString(1,room.getName());
        preparedStatement.setString(2,room.getDescription());
        preparedStatement.setString(3,room.getLocation());
        preparedStatement.setDouble(4,room.getPrice());
        preparedStatement.setString(5,room.getImg());
        preparedStatement.setString(6,room.getStatus().toString());
        preparedStatement.executeUpdate();


    }
}
