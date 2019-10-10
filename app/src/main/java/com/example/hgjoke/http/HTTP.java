package com.example.hgjoke.http;

import android.text.TextUtils;

import com.example.hgjoke.App;
import com.example.hgjoke.model.BaseModel;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author:hm
 * Date:2019/9/28
 */
public class HTTP {
    private final static String MD5_KEY = "aebb71d041d59a7d6a7257a204238aa0";
    private static API API;
    public static String url="http://192.168.250.95:8080/";
    /**
     * 初始化网络请求，在Application创建的时候调用,确保只初始化一次
     */
    public static void init() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        API = builder.build().create(API.class);
    }
    //接口=======================
    private static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        String token = "1";
        if (!TextUtils.isEmpty(token))
            map.put("token", token);
        map.put("requestDevice", "android");
        map.put("time", System.currentTimeMillis() + "");
        return map;
    }
    /**
     * 后台网络,前台UI线程
     */
    private static <T> Observable<T> thread(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
    public static Observable<BaseModel> TestMy(String name) {
        Map<String, String> map = getMap();
        map.put("name",name);
        return thread(API.TestMy(map));
    }
}
