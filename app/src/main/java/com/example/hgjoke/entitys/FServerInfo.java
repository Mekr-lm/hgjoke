package com.example.hgjoke.entitys;

import java.io.Serializable;

/**
 * author:hm
 * Date:2019/11/20
 */
public class FServerInfo implements Serializable {
    private int price;
    private String name;
    private String context;
    private String title;
    private String time;
    private int paid;

    public FServerInfo(int price,String name,String context,String title,String time,int paid){
        this.price = price;
        this.name = name;
        this.context = context;
        this.title = title;
        this.time = time;
        this.paid = paid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }
}
