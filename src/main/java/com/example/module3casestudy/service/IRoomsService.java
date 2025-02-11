package com.example.module3casestudy.service;

import com.example.module3casestudy.model.Rooms;

import java.util.List;

public interface IRoomsService {

    List<Rooms> findAll();

    void create(Rooms rooms);

    void save(Rooms rooms);


}
