package com.tyut.controller.message;

import com.tyut.po.Message;
import com.tyut.po.User;
import com.tyut.service.MessageService;
import com.tyut.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllMyMessageByIdServlet")
public class FindAllMyMessageByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        MessageService messageService = new MessageServiceImpl();
        List<Message> allMyMessageByIdServlet = messageService.findAllMyMessageByIdServlet(user.getUid());
        req.setAttribute("messages",allMyMessageByIdServlet);
        req.getRequestDispatcher("/basic_table3.jsp").forward(req,resp);
    }
}
