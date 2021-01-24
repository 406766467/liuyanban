package com.tyut.service.impl;

import com.tyut.dao.ReplyDao;
import com.tyut.dao.impl.ReplyDaoImpl;
import com.tyut.po.Reply;
import com.tyut.service.ReplyService;

import java.util.List;

public class ReplyServiceImpl implements ReplyService {
    private ReplyDao replyDao = new ReplyDaoImpl();
    @Override
    public List<Reply> findReplyByMid(Integer id) {
        return replyDao.findReplyByMid(id);
    }

    @Override
    public int addReply(Reply reply) {
        return replyDao.addReply(reply);
    }
}
