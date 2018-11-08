package com.example.bmp.entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int       id;               // 用户编号
    private String name;                // 姓名
    private String password;            // 密码
    private  int   state;           // 状态  1正常，2 禁用 ，0 删除
    private Date createtime;     //创建时间
    private  Date updatetime;    //更新时间

    public User()
    {}
    public User(String name, String password, int state, Date createtime, Date updatetime) {
        this.name = name;
        this.password = password;
        this.state = state;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
