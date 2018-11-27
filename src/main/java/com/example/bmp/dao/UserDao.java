package com.example.bmp.dao;

import com.example.bmp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
  //通过用户名和姓名查找
    User findByNameAndPassword(String name,String password);
    //保存用户
    User save(User user);
}
