package com.example.hgjoke.activity;

import android.os.Bundle;

import com.example.hgjoke.R;

public class HomePublishActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_publish;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitleText("发布需求");
    }
}
