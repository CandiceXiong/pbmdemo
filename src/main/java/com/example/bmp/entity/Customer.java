package com.example.bmp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String openid;    //
    private int Answer1;  //问题一 单选   必填
    private int Answer2;  //问题二 单选   必填
    private  String code;     //号码牌
    private  int  status;     //使用状态        1 使用 0未使用
    private Date createtime; //创建时间
    private  Date updatetime;  //更新时间

    public Customer()
    {

    }
    public Customer(String openid, int answer1, int answer2, String code, int status, Date createtime, Date updatetime) {
        this.openid = openid;
        Answer1 = answer1;
        Answer2 = answer2;
        this.code = code;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public int getAnswer1() {
        return Answer1;
    }

    public void setAnswer1(int answer1) {
        Answer1 = answer1;
    }

    public int getAnswer2() {
        return Answer2;
    }

    public void setAnswer2(int answer2) {
        Answer2 = answer2;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

