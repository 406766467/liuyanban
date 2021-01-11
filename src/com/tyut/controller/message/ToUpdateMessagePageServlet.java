package com.tyut.controller.message;

import com.tyut.po.Message;
import com.tyut.service.MessageService;
import com.tyut.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toUpdateMessagePageServlet")
public class ToUpdateMessagePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MessageService messageService = new MessageServiceImpl();
        String id = req.getParameter("id");
        Message messageById = messageService.findMessageById(Integer.parseInt(id));
        req.setAttribute("message",messageById);
        req.getRequestDispatcher("/contactform.jsp").forward(req,resp);
    }
}
