package com.tyut.controller.user;

import com.tyut.service.UserService;
import com.tyut.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateStatusServlet")
public class UpdateStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String id = req.getParameter("id");
        userService.updateStatus(Integer.parseInt(id));
        req.getRequestDispatcher("/findAllUserServlet").forward(req,resp);
    }
}
