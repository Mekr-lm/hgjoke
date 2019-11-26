package com.example.hgjoke.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hgjoke.R;
import com.example.hgjoke.activity.login.LoginActivity;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * author:hm
 * Date:2019/11/8
 */
public class MeFragment extends BaseFragment implements View.OnClickListener{
    @BindView(R.id.tv_me_name)
    TextView mTvName;
    @BindView(R.id.iv_me_avatar)
    CircleImageView mImg;
    @Override
    protected int getLayoutID() {
        return R.layout.fragment_me;
    }

    @Override
    protected void init(View view, Bundle savedInstanceState) {
        mTvName.setOnClickListener(this);
        mImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_me_name:
                startActivity(new Intent(mContext, LoginActivity.class));
                break;
            case R.id.iv_me_avatar:

                break;
        }
    }
}
