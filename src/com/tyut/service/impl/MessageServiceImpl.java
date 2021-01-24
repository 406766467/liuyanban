package com.tyut.service.impl;

import com.tyut.dao.MessageDao;
import com.tyut.dao.impl.MessageDaoImpl;
import com.tyut.po.Message;
import com.tyut.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    private MessageDao userDao = new MessageDaoImpl();
    @Override
    public List<Message> findAllMessageServlet() {
        return userDao.FindAllMessageServlet();
    }

    @Override
    public List<Message> findAllMyMessageByIdServlet(Integer id) {
        return userDao.findAllMyMessageByIdServlet(id);
    }

    @Override
    public int deleteMessageById(Integer id) {
        return userDao.deleteMessageById(id);
    }

    @Override
    public Message findMessageById(Integer id) {
        return userDao.findMessageById(id);
    }

    @Override
    public int updateMessageById(Integer id, String content) {
        return userDao.updateMessageById(id,content);
    }

    @Override
    public int addMessage(Message message) {
        return userDao.addMessage(message);
    }
}
