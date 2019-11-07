package com.example.hgjoke.utils;

import android.text.TextUtils;

import com.example.hgjoke.App;


/**
 * 2017/12/16.
 */

public class Toast {
    private static android.widget.Toast mToast;

    /**
     * Toast
     *
     * @param res 资源ID
     */
    public static void show(int res) {
        show(App.AppCtx.getString(res));
    }

    /**
     * Toast
     *
     * @param text 文本
     */
    public static void show(String text) {
        if (TextUtils.isEmpty(text)) //空文本不显示
            return;
        if (mToast != null)
            mToast.cancel();
        mToast = android.widget.Toast.makeText(App.AppCtx, text, android.widget.Toast.LENGTH_SHORT);
        mToast.show();
    }
}
