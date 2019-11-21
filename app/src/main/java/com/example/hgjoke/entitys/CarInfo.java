package com.example.hgjoke.entitys;

import java.io.Serializable;

/**
 * author:hm
 * Date:2019/11/20
 */
public class CarInfo implements Serializable {
    private String title;
    private String name;
    private String content;
    public CarInfo(String title, String content, String name){
        this.title = title;
        this.content = content;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
