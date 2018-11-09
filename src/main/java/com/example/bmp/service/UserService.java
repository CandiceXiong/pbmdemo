package com.example.bmp.service;

import com.example.bmp.dao.UserDao;
import com.example.bmp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    //通过姓名和密码进行登录
    public User getUser(String name,String password)
    {
        User user=userDao.findByNameAndPassword (name,password);
        return user;
    }
    //保存用户信息
    public User save(User user)
    {
        userDao.save (user);
        return user;
    }
}
