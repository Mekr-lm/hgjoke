package com.example.hgjoke.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hgjoke.R;
import com.example.hgjoke.activity.login.LoginActivity;
import com.example.hgjoke.activity.login.RegisterActivity;

import butterknife.BindView;

/**
 * author:hm
 * Date:2019/11/8
 */
public class MeFragment extends BaseFragment {
    @BindView(R.id.tv_login)
    TextView mTvLogin;
    @BindView(R.id.tv_reg)
    TextView mTvReg;
    @Override
    protected int getLayoutID() {
        return R.layout.fragment_me;
    }

    @Override
    protected void init(View view, Bundle savedInstanceState) {
        mTvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, LoginActivity.class));
            }
        });
        mTvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, RegisterActivity.class));
            }
        });
    }
}
