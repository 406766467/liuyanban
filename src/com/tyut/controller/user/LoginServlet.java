package com.tyut.controller.user;


import com.tyut.po.Message;
import com.tyut.po.Message_User;
import com.tyut.po.User;
import com.tyut.service.MessageService;
import com.tyut.service.ReplyService;
import com.tyut.service.UserService;
import com.tyut.service.impl.MessageServiceImpl;
import com.tyut.service.impl.ReplyServiceImpl;
import com.tyut.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet   extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> map = req.getParameterMap();
        HttpSession session = req.getSession();
        User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service=new UserServiceImpl();
        MessageService messageService = new MessageServiceImpl();
        ReplyService replyService = new ReplyServiceImpl();
        User loginuser=service.loginUser(user);
        if(loginuser!=null){
            //成功
            session.setAttribute("user",loginuser);
            List<Message> allMessageServlet = messageService.findAllMessageServlet();
            List<Message_User> list = new ArrayList<>();
            for (int i = 0; i < allMessageServlet.size(); i++) {
                int number = replyService.findReplyByMid(allMessageServlet.get(i).getMid()).size();
                User userById = service.findUserById(allMessageServlet.get(i).getUid());
                list.add(new Message_User(i+1,allMessageServlet.get(i).getTitle(),String.valueOf(number),userById.getUsername()));
            }
            req.setAttribute("messages",list);
            req.getRequestDispatcher("/MessageList.jsp").forward(req,resp);

        }else {
            req.setAttribute("login_msg","用户名或密码错误");
            req.getRequestDispatcher("/Login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
