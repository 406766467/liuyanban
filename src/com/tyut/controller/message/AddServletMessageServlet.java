package com.tyut.controller.message;

import com.tyut.po.Message;
import com.tyut.po.Message_User;
import com.tyut.po.User;
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

@WebServlet("/addServletMessageServlet")
public class AddServletMessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        User user = (User) req.getSession().getAttribute("user");
        Message message = new Message(null,title,content,user.getUid(),"getMessageContent");
        MessageService messageService = new MessageServiceImpl();
        ReplyService replyService = new ReplyServiceImpl();
        UserService service=new UserServiceImpl();
        int j = messageService.addMessage(message);
        if (j > 0){
            List<Message> allMessageServlet = messageService.findAllMessageServlet();
            List<Message_User> list = new ArrayList<>();
            for (int i = 0; i < allMessageServlet.size(); i++) {
                int number = replyService.findReplyByMid(allMessageServlet.get(i).getMid()).size();
                User userById = service.findUserById(allMessageServlet.get(i).getUid());
                list.add(new Message_User(i+1,allMessageServlet.get(i).getTitle(),String.valueOf(number),userById.getUsername(),null,allMessageServlet.get(i).getMid().toString()));
            }
            req.setAttribute("message_msg","留言成功！");
            req.setAttribute("messages",list);
        }else {
            req.setAttribute("message_msg","留言失败！");
        }

        req.getRequestDispatcher("/MessageList.jsp").forward(req,resp);
    }
}
