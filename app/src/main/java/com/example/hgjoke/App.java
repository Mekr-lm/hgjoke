package com.example.hgjoke;

import android.content.Context;
import android.util.Log;

import androidx.multidex.MultiDexApplication;

import com.example.hgjoke.http.HTTP;

/**
 * author:hm
 * Date:2019/9/28
 */
public class App extends MultiDexApplication {

    public static Context AppCtx;
    @Override
    public void onCreate() {
        super.onCreate();
        HTTP.init();
        AppCtx = getApplicationContext();
    }

}
