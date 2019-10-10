package com.example.hgjoke.model;

/**
 * author:hm
 * Date:2019/9/28
 */
public class BaseModel {
    private String msg;
    private int code;
    private boolean isOk(){
        if (code == 1010) {
            return true;
        }
        return false;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
