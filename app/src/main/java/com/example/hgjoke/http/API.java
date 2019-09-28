package com.example.hgjoke.http;

import com.example.hgjoke.model.BaseModel;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * author:hm
 * Date:2019/9/28
 */
public interface API {
    @POST("search/html")
    @FormUrlEncoded
    Observable<BaseModel> TestMy(@FieldMap Map<String, String> param);

}
