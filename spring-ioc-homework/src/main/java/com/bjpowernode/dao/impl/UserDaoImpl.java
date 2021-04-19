package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.domain.SysUser;

/**
 * Hello world!
 *
 */
public class UserDaoImpl implements UserDao
{
    @Override
    public void intsertUser(SysUser user) {
        // TODO Auto-generated method stub
        System.out.println("user插入到mysql数据库中:"+user);
    }
}
