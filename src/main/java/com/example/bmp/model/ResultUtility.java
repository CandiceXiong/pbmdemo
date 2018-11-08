package com.example.bmp.model;

public class ResultUtility {
    //{status:"true",code:"0001",msg:"获取成功！"}
    //{status:"false",msg:"code已领取完!"}

    private boolean status;  //是否成功
    private String msg;        //返回提示的消息
    private String data;      // 主要返回的数据

    public ResultUtility(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResultUtility(boolean status, String msg, String data) {
        this.status = status;
        this.msg = msg;
        this.data =data;
    }

    @Override
    public String toString() {
        return "ResultUtility{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
