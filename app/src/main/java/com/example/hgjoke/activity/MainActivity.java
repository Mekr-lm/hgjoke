package com.example.hgjoke.activity;

import android.os.Bundle;
import android.util.Log;

import com.example.hgjoke.R;
import com.example.hgjoke.http.HTTP;

/**
 * author:hm
 * Date:2019/9/28
 */
public class MainActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rxDestroy(HTTP.TestMy("你好")).subscribe(model->{
            Log.d("TestData",model.getMsg());
        },e->{
//            Log.d("TestData","2");
            e.printStackTrace();
        });
    }
}
