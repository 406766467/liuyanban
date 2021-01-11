package com.tyut.controller.message;

import com.tyut.po.Message;
import com.tyut.service.MessageService;
import com.tyut.service.impl.MessageServiceImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllMessageServlet")
public class FindAllMessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MessageService messageService = new MessageServiceImpl();
        List<Message> messages = messageService.findAllMessageServlet();
        req.setAttribute("messages",messages);
        req.getRequestDispatcher("/basic_table1.jsp").forward(req,resp);

    }
}
