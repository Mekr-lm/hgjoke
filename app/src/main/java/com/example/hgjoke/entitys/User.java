package com.example.hgjoke.entitys;

/**
 * author:hm
 * Date:2019/11/8
 */
public class User {
    private String authName;
    private String token;
    private UserInfo user;
    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }
}

