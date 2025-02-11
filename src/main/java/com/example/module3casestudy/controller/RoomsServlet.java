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

@WebServlet(name = "rooms", value = "/rooms")
public class RoomsServlet extends HttpServlet {
    private final static IRoomsService service = new RoomsServiceDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            try {
                showRoom(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/create.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    private static void showRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        IRoomsService service = new RoomsServiceDB();
        List<Rooms> rooms = service.findAll();
//    chuyen huong sang view
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/rooms-list.jsp");
        req.setAttribute("rooms", rooms);
        requestDispatcher.forward(req, resp);
    }
}
