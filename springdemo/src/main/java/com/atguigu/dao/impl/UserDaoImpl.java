package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;

/**
 * @Classname UserDaoImpl
 * @Description TODO
 * @Date 2022/2/10 11:32
 * @Author Administrator
 * @Version 1.0.0
 */
public class UserDaoImpl implements UserDao {

    private String username;

    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void add() {
        System.out.println("UserDao add ==> " + username + " = " + password);
    }
}
