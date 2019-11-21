package com.example.hgjoke.http;

import com.example.hgjoke.model.BaseModel;
import com.example.hgjoke.model.UserModel;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * author:hm
 * Date:2019/9/28
 */
public interface API {
    @POST("test")
    @FormUrlEncoded
    Observable<UserModel> TestMy(@FieldMap Map<String, String> param);

    @POST("login")
    @FormUrlEncoded
    Observable<UserModel> login(@FieldMap Map<String, String> param);

    @POST("register")
    @FormUrlEncoded
    Observable<BaseModel> register(@FieldMap Map<String, String> param);
}
