package com.tyut.service;

import com.tyut.po.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> findReplyByMid(Integer id);
    int addReply(Reply reply);
}
