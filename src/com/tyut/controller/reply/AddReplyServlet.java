package com.tyut.controller.reply;

import com.tyut.po.Reply;
import com.tyut.po.User;
import com.tyut.service.ReplyService;
import com.tyut.service.impl.ReplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addReplyServlet")
public class AddReplyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String content = req.getParameter("content");
        String mid = req.getParameter("mid");
        User user = (User) req.getSession().getAttribute("user");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        Reply reply = new Reply(null,content,user.getUid(),Integer.parseInt(mid),format);
        ReplyService replyService = new ReplyServiceImpl();
        req.setAttribute("id",mid);
        if (user.getStatus() == 0){
            int i = replyService.addReply(reply);
            if (i > 0) {
                req.setAttribute("message_msg","留言成功！");
            }else {
                req.setAttribute("message_msg","留言失败！");
            }
        }else {
            req.setAttribute("message_msg","您已被禁言！");
        }

        req.getRequestDispatcher("/getMessageContentServlet").forward(req,resp);
    }
}
