package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.service.UserService;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2022/2/10 11:31
 * @Author Administrator
 * @Version 1.0.0
 */
public class UserServiceImpl implements UserService {

    private  UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("UserService add...");
        userDao.add();
    }
}
