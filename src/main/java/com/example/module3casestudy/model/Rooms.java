package com.example.module3casestudy.model;


import com.example.module3casestudy.eNum.RoomStatusENum;

public class Rooms {
    private int id;
    private String name;
    private String description;
    private String location;
    private double price;
    private String img;
    RoomStatusENum status;

    public Rooms() {
        this.status = RoomStatusENum.available;
    }

    public Rooms(int id, String name, String description, String location, double price,String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.price = price;
        this.img = img;
        this.status = RoomStatusENum.available;
    }


    public Rooms(String name, String description, String location, double price,String img , RoomStatusENum status) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.price = price;
        this.img = img;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public RoomStatusENum getStatus() {
        return status;
    }

    public void setStatus(RoomStatusENum status) {
        this.status = status;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }


}
