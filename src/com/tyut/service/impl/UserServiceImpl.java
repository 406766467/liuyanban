package com.tyut.service.impl;

import com.tyut.dao.UserDao;
import com.tyut.dao.impl.UserDaoImpl;
import com.tyut.po.User;
import com.tyut.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public int updateUserType(Integer id) {
        User user = userDao.findUserById(id);
        int result = 0;
        if (user.getUserType() == 1){
            result = userDao.updateUserType(id,0);
        }else {
            result = userDao.updateUserType(id,1);
        }
        return result;
    }

    @Override
    public int updateStatus(Integer id) {
        User user = userDao.findUserById(id);
        int result = 0;
        if (user.getStatus() == 1){
            result = userDao.updateStatus(id,0);
        }else {
            result = userDao.updateStatus(id,1);
        }
        return result;
    }

    @Override
    public User loginUser(User user) {
        return userDao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }


}
