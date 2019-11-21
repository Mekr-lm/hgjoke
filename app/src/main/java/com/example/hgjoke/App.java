package com.example.hgjoke;

import android.content.Context;
import android.util.DisplayMetrics;

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
    public static DisplayMetrics metrics;
    public static int w;
    public static int h;
    @Override
    public void onCreate() {
        super.onCreate();
        HTTP.init();
        AppCtx = getApplicationContext();
        metrics=this.getResources().getDisplayMetrics();
        w = metrics.widthPixels;
        h = metrics.heightPixels;
    }
    public static String getToken(){
        if(user!=null) {
            return user.getAuthName();
        }else {
            return "";
        }
    }
}
