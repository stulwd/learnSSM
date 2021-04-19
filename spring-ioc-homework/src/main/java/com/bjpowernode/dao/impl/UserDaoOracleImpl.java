package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.domain.SysUser;

public class UserDaoOracleImpl implements UserDao {

    @Override
    public void intsertUser(SysUser user) {
        // TODO Auto-generated method stub
        System.out.println("user插入到mysql数据库中（oracle数据库）:"+user);
    }
    
}

