package com.tyut.dao.impl;

import com.tyut.dao.UserDao;
import com.tyut.po.Message;
import com.tyut.po.User;
import com.tyut.service.UserService;
import com.tyut.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAllUser() {
        String sql = "select * from user where usertype = 0";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public User findUserById(Integer id) {
        String sql = "select * from user where uid = "+ id;
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class) );
        return user;
    }

    @Override
    public int updateUserType(Integer id,Integer userType) {
        String sql = "update user set usertype = "+ userType +" where uid = "+id;
        int update = template.update(sql);
        return update;
    }

    @Override
    public int updateStatus(Integer id,Integer status) {
        String sql = "update user set status = "+ status +" where uid = "+id;
        int update = template.update(sql);
        return update;
    }
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try{
            String sql="select *from user where username=? and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),username,password);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

}
