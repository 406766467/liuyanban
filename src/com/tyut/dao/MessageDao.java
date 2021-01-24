package com.tyut.dao;

import com.tyut.po.Message;

import java.util.List;

public interface MessageDao {
    List<Message> FindAllMessageServlet();
    List<Message> findAllMyMessageByIdServlet(Integer id);
    int deleteMessageById(Integer id);
    Message findMessageById(Integer id);
    int updateMessageById(Integer id,String content);
    int addMessage(Message message);
}
