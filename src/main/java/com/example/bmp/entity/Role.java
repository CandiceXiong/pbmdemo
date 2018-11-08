package com.example.bmp.entity;

import javax.persistence.*;


import java.sql.Date;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String rolecode ;   //角色编号
    private String rolename ;  //角色名称
    private int State ;        //状态  1正常，2 禁用 ，0 删除
    private Date createtime;     //创建时间
    private  Date updatetime;    //更新时间

    public Role()
    {

    }
    public Role(String rolecode, String rolename, int state, Date createtime, Date updatetime) {
        this.rolecode = rolecode;
        this.rolename = rolename;
        State = state;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
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
