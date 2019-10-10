package com.example.hgjoke.entitys;

import java.util.List;
/**
 * author:hm
 * Date:2019/9/28
 */
public class EBData {
    private int type;
    public int arg1;
    public int arg2;
    public int arg3;
    public String str1;
    private boolean isState;
    public List<String> strs;
    public Object obj;

    public EBData(int type) {
        this.type = type;
    }

    public EBData(int type, int arg1, Object obj) {
        this.type = type;
        this.arg1 = arg1;
        this.obj = obj;
    }

    public EBData(int type, String str1) {
        this.type = type;
        this.str1 = str1;
    }

    public EBData(int type, List<String> strs) {
        this.type = type;
        this.strs = strs;
    }

    public EBData(int type, int arg1, String str1) {
        this.type = type;
        this.arg1 = arg1;
        this.str1 = str1;
    }

    public EBData(int type, boolean isState) {
        this.type = type;
        this.isState = isState;
    }

    public EBData(int type, int arg1) {
        this.type = type;
        this.arg1 = arg1;
    }

    public EBData(int type, int arg1, int arg2) {
        this.type = type;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public EBData(int type, int arg1, int arg2, int arg3) {
        this.type = type;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
    }


    public boolean isState() {
        return isState;
    }

    public void setState(boolean state) {
        isState = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
