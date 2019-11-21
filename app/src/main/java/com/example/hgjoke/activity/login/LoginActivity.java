package com.example.hgjoke.activity.login;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.hgjoke.App;
import com.example.hgjoke.R;
import com.example.hgjoke.activity.BaseActivity;
import com.example.hgjoke.http.HTTP;

import butterknife.BindView;

/**
 * author:hm
 * Date:2019/11/11
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_log_account)
    EditText mTvNickName;
    @BindView(R.id.et_log_pswd)
    EditText mTvPwd;
    @BindView(R.id.btn_login)
    Button mTvbtn;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        mTvbtn.setOnClickListener(view -> rxDestroy(HTTP.login(mTvNickName.getText().toString().trim(),mTvPwd.getText().toString().trim())).subscribe(model->{
            if(model.isOk()){
                toast("登录成功");
                App.user = model.getData();
                Log.d("TestData",App.user.getUser().getNickname());
            }else{
                toast(model.getMsg());
            }
        },e->{
            e.printStackTrace();
        }));
    }
}
