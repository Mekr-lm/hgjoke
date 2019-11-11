package com.example.hgjoke.model;

import com.example.hgjoke.entitys.User;

/**
 * author:hm
 * Date:2019/11/7
 */
public class UserModel extends BaseModel {
    private User data;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
