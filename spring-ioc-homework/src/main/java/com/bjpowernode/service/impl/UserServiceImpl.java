package com.bjpowernode.service.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.domain.SysUser;
import com.bjpowernode.service.UserService;

public class UserServiceImpl implements UserService{
    private UserDao dao = null;
    
    @Override
    public void addUser(SysUser user) {
        dao.intsertUser(user);
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

}