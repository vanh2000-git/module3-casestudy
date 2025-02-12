package com.example.module3casestudy.service;

import com.example.module3casestudy.model.Rooms;

import java.sql.SQLException;
import java.util.List;

public interface IRoomsService {

    List<Rooms> findAll() throws SQLException;

    void create(Rooms rooms);

    void save(Rooms rooms) throws SQLException;

    Rooms findById(int roomId);


    boolean updateRoom(int roomId, Rooms updatedRoom);
    boolean deleteRoom(int roomId);

}
