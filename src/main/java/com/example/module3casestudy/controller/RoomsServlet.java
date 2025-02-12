package com.example.module3casestudy.controller;


import com.example.module3casestudy.eNum.RoomStatusENum;
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
        action = action == null ? "" : action;
        switch (action) {
            case "list":
                showRoom(req, resp);
                break;
            case "create":
                showFormCreate(req, resp);
                break;
            case "delete":
                deleteRoom(req, resp);
                break;
            case "edit":
                showFormEdit(req, resp);
                break;
            default:
                showRoom(req, resp);
        }
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id"));
        Rooms room = service.findById(id);
        if (room == null) {
            String error = "EDIT - Room not found for ID: " + id;
            req.setAttribute("error", error);
            req.getRequestDispatcher("/notFound.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("room", room);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    private void deleteRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean isDeleted = service.deleteRoom(id);
        if (isDeleted) {
            resp.sendRedirect(req.getContextPath() + "/rooms?action=list");
        } else {
            String error = "DELETE - Delete failed!";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/notFound.jsp").forward(req, resp);
        }
    }


    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/create.jsp").forward(req, resp);
    }

    private void showRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IRoomsService service = new RoomsServiceDB();
        List<Rooms> rooms = null;
        try {
            rooms = service.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//    chuyen huong sang view
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/rooms-list.jsp");
        req.setAttribute("rooms", rooms);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create":
                createRoom(req, resp);
                break;
            case "edit":
                updateCustomer(req, resp);
                break;
        }
    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name =req.getParameter("name");
        String description =req.getParameter("description");
        String location =req.getParameter("location");
        double price = Double.parseDouble(req.getParameter("price"));
        String img =req.getParameter("img");
        RoomStatusENum status = RoomStatusENum.valueOf(req.getParameter("status").toLowerCase());
        Rooms room = new Rooms(name,description,location,price,img,status);
        boolean isUpdated = service.updateRoom(id, room);
        if (isUpdated) {
            resp.sendRedirect(req.getContextPath() + "/rooms?action=list");
        }else{
            req.setAttribute("error", "Update failed!");
            req.getRequestDispatcher("/edit.jsp").forward(req, resp);
        }
    }

    private void createRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name =req.getParameter("name");
        String description =req.getParameter("description");
        String location =req.getParameter("location");
        double price = Double.parseDouble(req.getParameter("price"));
        String img =req.getParameter("img");
//        RoomStatusENum status = RoomStatusENum.valueOf(req.getParameter("status").toLowerCase());


        Rooms room = new Rooms(name,description,location,price,img);
        System.out.println(room);
        try {
            service.save(room);
            resp.sendRedirect(req.getContextPath() + "/rooms?action=list");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}