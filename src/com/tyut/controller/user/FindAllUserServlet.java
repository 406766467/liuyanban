package com.tyut.controller.user;

import com.tyut.po.User;
import com.tyut.service.UserService;
import com.tyut.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllUserServlet")
public class FindAllUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        List<User> allUser = userService.findAllUser();
        req.setAttribute("users",allUser);
        req.getRequestDispatcher("/basic_table2.jsp").forward(req,resp);
    }
}
