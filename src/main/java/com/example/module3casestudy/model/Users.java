package com.example.module3casestudy.model;

import com.example.module3casestudy.eNum.UserEnum;

public class Users {
private int id;
private String name;
private String phone;
private String password;
private String image;
UserEnum role;

    public Users() {
        this.role = UserEnum.customer;
    }

    public Users(int id, String name, String phone, String password, String image) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.image = image;
        this.role = UserEnum.customer;
    }

    public Users(String name, String phone, String password, String image) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.image = image;
        this.role = UserEnum.customer;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UserEnum getRole() {
        return role;
    }

    public void setRole(UserEnum role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", role=" + role +
                '}';
    }
}
