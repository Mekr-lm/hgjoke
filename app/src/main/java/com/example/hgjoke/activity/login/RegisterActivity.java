package com.example.hgjoke.activity.login;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.hgjoke.R;
import com.example.hgjoke.activity.BaseActivity;
import com.example.hgjoke.http.HTTP;

import butterknife.BindView;

/**
 * author:hm
 * Date:2019/11/11
 */
public class RegisterActivity extends BaseActivity {
    @BindView(R.id.et_lg_verification)
    EditText mTvnickName;
    @BindView(R.id.et_lg_password)
    EditText mTvPwd;
    @BindView(R.id.btn_lg_complete)
    Button mTvbtn;
    @Override
    protected int getLayoutId(){
        return R.layout.activity_register;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        mTvbtn.setOnClickListener(view -> {
            Log.d("TestData","1");
            rxDestroy(HTTP.register(mTvnickName.getText().toString().trim(),mTvPwd.getText().toString().trim())).subscribe(model->{
                if(model.isOk()){
                    toast("注册成功");
                    finish();
                }else{
                    toast(model.getMsg());
                }
            },e->{
                e.printStackTrace();
            });
        });
    }
}
