package com.example.hgjoke.utils;

import android.content.Context;
import android.widget.Toast;

public class Util {
//    public static final String ws = "ws://echo.websocket.org";//websocket测试地址
    public static final String ws = "ws://192.168.250.84:8763/websocket/1234";//websocket测试地址
    public static void showToast(Context ctx, String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show();
    }
}
