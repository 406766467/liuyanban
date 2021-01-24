package com.tyut.dao;

import com.tyut.po.Reply;

import java.util.List;

public interface ReplyDao {
    List<Reply> findReplyByMid(Integer id);
    int addReply(Reply reply);
}
