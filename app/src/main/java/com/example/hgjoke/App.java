package com.example.hgjoke;

import android.util.Log;

import androidx.multidex.MultiDexApplication;

import com.example.hgjoke.http.HTTP;

/**
 * author:hm
 * Date:2019/9/28
 */
public class App extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        HTTP.init();
    }

}
