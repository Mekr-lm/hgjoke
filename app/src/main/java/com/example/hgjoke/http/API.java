package com.example.hgjoke.http;

import com.example.hgjoke.model.TestModel;

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
    @POST("hi")
    @FormUrlEncoded
    Observable<TestModel> TestMy(@FieldMap Map<String, String> param);
}
