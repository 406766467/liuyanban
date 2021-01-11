package com.tyut.service;

import com.tyut.po.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    User findUserById(Integer id);
    int updateUserType(Integer id);
    int updateStatus(Integer id);
    User loginUser(User user);

}
