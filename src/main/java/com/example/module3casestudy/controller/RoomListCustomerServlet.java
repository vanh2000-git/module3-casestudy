package com.example.module3casestudy.controller;

import com.example.module3casestudy.model.Rooms;
import com.example.module3casestudy.service.IRoomsService;
import com.example.module3casestudy.service.RoomsServiceDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "roomList", value = "/roomlist")
public class RoomListCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "list":
                showRoom(req, resp);
                break;
            default:
                showRoom(req, resp);
        }
    }

    private void showRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IRoomsService service = new RoomsServiceDB();
        List<Rooms> rooms = null;
        try {
            rooms = service.findAll();
            System.out.println(rooms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//    chuyen huong sang view
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/customerPage.jsp");
        req.setAttribute("rooms", rooms);
        requestDispatcher.forward(req, resp);
    }
}
