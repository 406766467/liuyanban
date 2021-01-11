package com.tyut.dao;

import com.tyut.po.User;

import java.util.List;

public interface UserDao {
    List<User> findAllUser();
    User findUserById(Integer id);
    int updateUserType(Integer id,Integer userType);
    int updateStatus(Integer id,Integer status);
    User findUserByUsernameAndPassword(String username, String password);
}
