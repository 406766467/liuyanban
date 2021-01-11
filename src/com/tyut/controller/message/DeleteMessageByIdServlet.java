package com.tyut.controller.message;

import com.tyut.service.MessageService;
import com.tyut.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteMessageByIdServlet")
public class DeleteMessageByIdServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        MessageService messageService = new MessageServiceImpl();
        messageService.deleteMessageById(Integer.parseInt(id));
        req.getRequestDispatcher("/findAllMessageServlet").forward(req,resp);

    }
}
