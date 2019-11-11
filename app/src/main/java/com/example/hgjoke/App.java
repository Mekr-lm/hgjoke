package com.example.hgjoke;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.example.hgjoke.entitys.User;
import com.example.hgjoke.http.HTTP;

/**
 * author:hm
 * Date:2019/9/28
 */
public class App extends MultiDexApplication {

    public static Context AppCtx;
    public static User user;
    @Override
    public void onCreate() {
        super.onCreate();
        HTTP.init();
        AppCtx = getApplicationContext();
    }
    public static String getToken(){
        if(user!=null) {
            return user.getToken();
        }else {
            return "";
        }
    }
}
