package com.example.module3casestudy.controller;

import com.example.module3casestudy.eNum.UserEnum;
import com.example.module3casestudy.model.Users;
import com.example.module3casestudy.repositories.IUserRepository;
import com.example.module3casestudy.repositories.UserRepository;
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
    private final IUserRepository iUserRepository = new UserRepository();
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
        try {
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");

            if(iUserRepository.ValidateUser(phone, password)) {
                System.out.println("Đã đăng nhập thành công : " );
                // Dang nhap thanh cong => get quyen cua user
                // Lay quyen cua User
                UserEnum role = iUserRepository.GetRoleOfUser(phone);

                if(role == UserEnum.admin) {
                    //  Redirect Admin Page
                    resp.sendRedirect("adminPage.jsp");
                } else {
                    // Redirect Customer Page
                    resp.sendRedirect("customerPage.jsp");
                }
            } else {
                // Redirect error page
                System.out.println("Đăng nhập thất bại : " );
                resp.sendRedirect("errorPage.jsp");
            }

        } catch (Exception ex) {
            // redirect error page
            System.out.println("Đăng nhập thất bại : " );
            resp.sendRedirect("errorPage.jsp");
        }
    }

    private void handleRegister(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            String username = req.getParameter("username");
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");
            String image = req.getParameter("image");

            Users users = new Users(username, phone, password,image);

            String phoneNumber = iUserRepository.InsertUser(users);

            System.out.println("Đã đăng ký thành công vơi phone : " + phoneNumber );
        }catch(Exception ex) {
            // redirect error page
            System.out.println("Đăng ký thất bại");
            resp.sendRedirect("errorPage.jsp");
        }
    }
}
