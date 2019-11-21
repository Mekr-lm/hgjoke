package com.example.hgjoke.entitys;

import java.io.Serializable;

/**
 * author:hm
 * Date:2019/11/20
 */
public class ShopListInfo implements Serializable {
    private String title;
    private String content;
    private String price;
    public ShopListInfo(String title,String content,String price){
        this.title = title;
        this.content = content;
        this.price = price;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
