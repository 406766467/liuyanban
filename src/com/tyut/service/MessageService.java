package com.tyut.service;

import com.tyut.po.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAllMessageServlet();
    List<Message> findAllMyMessageByIdServlet(Integer id);
    int deleteMessageById(Integer id);
    Message findMessageById(Integer id);
    int updateMessageById(Integer id,String content);
}
