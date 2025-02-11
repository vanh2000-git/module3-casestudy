package com.example.module3casestudy.repositories;

import com.example.module3casestudy.eNum.UserEnum;
import com.example.module3casestudy.model.Users;

public interface IUserRepository {
    String InsertUser(Users user); // return phoneNumber
    Users GetUserByPhone(String phone);
    boolean ValidateUser(String phone, String password);
    UserEnum GetRoleOfUser(String phone);
}
