package com.tyut.controller.message;

import com.tyut.po.*;
import com.tyut.service.MessageService;
import com.tyut.service.ReplyService;
import com.tyut.service.UserService;
import com.tyut.service.impl.MessageServiceImpl;
import com.tyut.service.impl.ReplyServiceImpl;
import com.tyut.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getMessageContentServlet")
public class GetMessageContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service=new UserServiceImpl();
        MessageService messageService = new MessageServiceImpl();
        ReplyService replyService = new ReplyServiceImpl();
        String id = req.getParameter("id") == null? (String) req.getAttribute("id") : req.getParameter("id");
        Message message = messageService.findMessageById(Integer.parseInt(id));
        User user = service.findUserById(message.getUid());
        List<Reply> replyByMid = replyService.findReplyByMid(message.getMid());
        //组合类创建
        Message_User message_user = new Message_User(Integer.parseInt(id),message.getTitle(),null,user.getUsername(),message.getContent());
        List<User_Reply> user_replies = new ArrayList<>();
        for (Reply temp:replyByMid){
            user_replies.add(new User_Reply(null,temp.getContent(),service.findUserById(temp.getUid()).getUsername(),temp.getTime()));
        }
        req.setAttribute("message",message_user);
        req.setAttribute("replys",user_replies);
        req.getRequestDispatcher("/showMessageContent.jsp").forward(req,resp);


    }
}
