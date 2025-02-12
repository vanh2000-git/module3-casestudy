package com.example.module3casestudy.service;

import com.example.module3casestudy.model.Rooms;

import java.util.ArrayList;
import java.util.List;

public class RoomsServiceImpl implements  IRoomsService{
    private static List<Rooms> rooms = new ArrayList<>();

    @Override
    public List<Rooms> findAll() {
        return rooms;
    }

    @Override
    public void create(Rooms room) {
        rooms.add(room);
    }

    @Override
    public void save(Rooms room) {

    }
}
