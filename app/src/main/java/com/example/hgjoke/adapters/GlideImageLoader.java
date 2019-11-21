package com.example.hgjoke.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.example.hgjoke.R;
import com.example.hgjoke.entitys.BannerInfo;
import com.example.hgjoke.utils.ImgUtils;
import com.youth.banner.loader.ImageLoader;

/**
 * scy
 * 2018/6/8.
 */

public class GlideImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        BannerInfo info = (BannerInfo) path;
        if (!TextUtils.isEmpty(info.getBannerImg())) {
            ImgUtils.loadBitmap(context,info.getBannerImg(), R.mipmap.ic_error_banner, imageView);
        } else {
            ImgUtils.loadBitmap(context,info.getImg(),R.mipmap.ic_error_banner, imageView);
        }

    }
}
