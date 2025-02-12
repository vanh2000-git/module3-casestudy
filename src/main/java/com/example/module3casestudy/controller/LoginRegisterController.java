package com.example.module3casestudy.controller;

import com.example.module3casestudy.eNum.UserEnum;
import com.example.module3casestudy.model.Users;
import com.example.module3casestudy.repositories.IUserRepository;
import com.example.module3casestudy.repositories.UserRepository;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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
                RequestDispatcher dispatcher = req.getRequestDispatcher("/errorPage.jsp");
                req.setAttribute("errorMessage", "Lỗi xử lý lại ");
                dispatcher.forward(req, resp);
                break;
        }
    }

    private void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");

            if(iUserRepository.ValidateUser(phone, password)) {
                System.out.println("Đã đăng nhập thành công : " );
                UserEnum role = iUserRepository.GetRoleOfUser(phone);

                Users users = iUserRepository.GetUserByPhone(phone);

                if(role == UserEnum.admin) {
                    req.setAttribute("users", users);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/adminPage.jsp");
                    dispatcher.forward(req, resp);
                } else {
                    req.setAttribute("users", users);
                    req.setAttribute("userName", users.getName());
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/customerPage.jsp");
                    dispatcher.forward(req, resp);
                }
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/errorPage.jsp");
                req.setAttribute("errorMessage", "Đăng nhập thất bại");
                dispatcher.forward(req, resp);


            }

        } catch (Exception ex) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/errorPage.jsp");
            req.setAttribute("errorMessage", "Đăng nhập thất bại");
            dispatcher.forward(req, resp);
        }
    }

    private void handleRegister(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try{
            String username = req.getParameter("username");
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");
            String image = req.getParameter("image");

            Users users = new Users(username, phone, password,image);

            String phoneNumber = iUserRepository.InsertUser(users);

            System.out.println("Đã đăng ký thành công vơi phone : " + phoneNumber );
        }catch(Exception ex) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/errorPage.jsp");
            req.setAttribute("errorMessage", "Tài khoản đăng ký thất bại , vui lòng đăng ký lại");
            dispatcher.forward(req, resp);
        }
    }
}
