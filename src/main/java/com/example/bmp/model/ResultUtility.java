package com.example.bmp.model;

public class ResultUtility {
    //{status:"true",code:"0001",msg:"获取成功！"}
    //{status:"false",msg:"code已领取完!"}

    private boolean status;  //是否成功
    private String msg;        //返回提示的消息
    private String code;      // 主要返回的数据


    public ResultUtility()
    {

    }
    public ResultUtility(boolean status, String msg) {
        this.status = status;
        this.msg = msg;

    }
    public ResultUtility(boolean status, String msg, String code) {
        this.status = status;
        this.msg = msg;
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResultUtility{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
