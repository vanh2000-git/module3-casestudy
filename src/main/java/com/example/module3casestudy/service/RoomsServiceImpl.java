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

    @Override
    public Rooms findById(int roomId) {
        for(Rooms room:rooms){
            if(room.getId()==roomId){
                return room;
            }
        }
        return null;
    }

    @Override
    public boolean updateRoom(int roomId, Rooms updatedRoom) {
        Rooms room = findById(roomId);
        if(room!=null){
            room.setName(updatedRoom.getName());
            room.setDescription(updatedRoom.getDescription());
            room.setPrice(updatedRoom.getPrice());
            room.setLocation(updatedRoom.getLocation());
            room.setImg(updatedRoom.getImg());
            room.setStatus(updatedRoom.getStatus());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRoom(int roomId) {
        return rooms.removeIf(rooms1 -> rooms1.getId()==roomId );
    }
}
