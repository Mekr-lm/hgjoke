package com.example.hgjoke.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hgjoke.R;


/**
 * scy
 * 2018/7/9.
 */

public class ImgUtils {

    public static void loadBitmap(Context content, String url, ImageView ImageView) {
        Glide.with(content)
                .load(url)
                .error(R.mipmap.ic_error_img)
                .crossFade()
                .into(ImageView);
    }

    public static void loadBitmap(Context content, String url, int resourceId, ImageView ImageView) {
        Glide.with(content)
                .load(url)
                .error(resourceId)
                .crossFade()
                .into(ImageView);
    }

    public static void loadBitmap(Context content, Integer url, int resourceId, ImageView ImageView) {
        Glide.with(content)
                .load(url)
                .error(resourceId)
                .into(ImageView);
    }

}
