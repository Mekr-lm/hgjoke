package com.example.hgjoke.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.hgjoke.R;
import com.example.hgjoke.entitys.FServerInfo;

import butterknife.BindView;

public class ServerDetailsActivity extends BaseActivity {
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.content)
    TextView content;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_server_details;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
    }
    public void initView(){
        FServerInfo data = (FServerInfo) getIntent().getSerializableExtra("data");
        name.setText(data.getName());
        time.setText("于"+data.getTime()+"发布该需求");
        title.setText(data.getTitle());
        price.setText(data.getPrice()+"元");
        content.setText(data.getContext());
    }
}
