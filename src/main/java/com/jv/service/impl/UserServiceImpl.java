package com.jv.service.impl;

import com.jv.dao.UserDao;
import com.jv.entity.User;
import com.jv.service.interf.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User findUserById(int id) {
        return userDao.findUserById(id);
    }
}
