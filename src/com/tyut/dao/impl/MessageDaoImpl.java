package com.tyut.dao.impl;

import com.tyut.dao.MessageDao;
import com.tyut.po.Message;
import com.tyut.po.User;
import com.tyut.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MessageDaoImpl implements MessageDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Message> FindAllMessageServlet() {
        String sql = "select * from message";
        List<Message> messages = template.query(sql, new BeanPropertyRowMapper<>(Message.class));
        return messages;
    }

    @Override
    public List<Message> findAllMyMessageByIdServlet(Integer id) {
        String sql = "select * from message where uid =" + id;
        List<Message> messages = template.query(sql, new BeanPropertyRowMapper<>(Message.class));
        return messages;
    }

    @Override
    public int deleteMessageById(Integer id) {
        String sql = "delete from message where mid = ?";
        int update = template.update(sql, id);
        return update;
    }

    @Override
    public Message findMessageById(Integer id) {
        String sql = "select * from message where mid = "+ id;
        Message message = template.queryForObject(sql, new BeanPropertyRowMapper<>(Message.class) );
        return message;
    }

    @Override
    public int updateMessageById(Integer id, String content) {
        String sql = "update message set content = '"+content +"' where mid = "+id;
        int update = template.update(sql);
        return update;
    }
}
