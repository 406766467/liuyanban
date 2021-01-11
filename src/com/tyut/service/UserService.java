package com.tyut.service;

import com.tyut.po.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    int updateUserType(Integer id);
    int updateStatus(Integer id);

}
