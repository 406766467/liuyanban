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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        String[] hobbies = req.getParameterValues("hobby");
        StringBuilder hobby = new StringBuilder();
        for (String temp:hobbies){
            hobby.append(temp).append(",");
        }
        String substring = hobby.substring(0, hobby.length() - 1);
        String introduce = req.getParameter("introduce");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        User user = new User(null,username,password,sex,substring,address,introduce,0,0,format);
        System.out.println(user.toString());
        UserService service=new UserServiceImpl();
        int i = service.addUser(user);
        if ( i > 0){
            req.setAttribute("login_msg","注册成功！请登录！");
            req.getRequestDispatcher("/Login.jsp").forward(req,resp);
        }else {
            req.setAttribute("login_msg","注册失败！请重新注册！");
            req.getRequestDispatcher("/Register.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
