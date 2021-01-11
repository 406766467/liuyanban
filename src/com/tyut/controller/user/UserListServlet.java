package com.tyut.controller.user;

import com.tyut.po.Message;
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

/**
 * @author: ZHX
 * @date: 2021/1/10 11:05
 * @description:
 */
@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用UserService完成查询
        UserService service=new UserServiceImpl();
        //List<Message> messages = service.findAll();
        List<User> users = service.findAllUser();

        //2.将list存入request域
        //req.setAttribute("messages",messages);
        req.setAttribute("users",users);
        //3.转发到list.jsp
        req.getRequestDispatcher("/MessageList.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
