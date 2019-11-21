package com.example.hgjoke.entitys;

/**
 * author:hm
 * Date:2019/11/21
 */
public class ShopInfo{
    private String name;
    private String content;
    public ShopInfo(String name,String content){
        this.name = name;
        this.content = content;
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

