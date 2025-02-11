package com.example.module3casestudy.controller;

import com.example.module3casestudy.utils.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "loginRegister", value = "/loginRegister")
public class LoginRegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {
            case "login":
                handleLogin(req, resp);
                break;
            case "register":
                handleRegister(req, resp);
                break;
            default:
                resp.setContentType("text/html;charset=UTF-8");
                resp.getWriter().write("<h3>Hành động không hợp lệ</h3>");
                break;
        }
    }

    private void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("select * from users where phone and password");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Username : " + username);
        System.out.println("Password : " + password);


    }



    private void handleRegister(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String image = req.getParameter("image");
        String defaultRole  = "customer";

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("select * from users where phone = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Username : " + username);
        System.out.println("Phone : " + phone);
        System.out.println("Password : " + password);
        System.out.println("Image : " + image);
        System.out.println("Default Role : " + defaultRole);



    }

}
