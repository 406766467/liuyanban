package com.tyut.dao.impl;

import com.tyut.dao.ReplyDao;
import com.tyut.po.Reply;
import com.tyut.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ReplyDaoImpl implements ReplyDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Reply> findReplyByMid(Integer id) {
        String sql = "select * from reply where mid = "+ id;
        List<Reply> query = template.query(sql, new BeanPropertyRowMapper<>(Reply.class));
        return query;
    }
}
