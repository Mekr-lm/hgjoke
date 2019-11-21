package com.example.hgjoke.activity;

import android.os.Bundle;

import com.example.hgjoke.R;
import com.example.hgjoke.entitys.ShopListInfo;

public class ShopDetailsActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_details;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initData();
    }
    public void initData(){
        ShopListInfo data = (ShopListInfo)getIntent().getSerializableExtra("data");

    }
}
