package com.example.hgjoke.activity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.hgjoke.R;
import com.example.hgjoke.adapters.MainFragmentAdapter;
import com.example.hgjoke.entitys.EBData;
import com.example.hgjoke.fragment.CarFragment;
import com.example.hgjoke.fragment.ClassFragment;
import com.example.hgjoke.fragment.HomeFragment;
import com.example.hgjoke.fragment.MeFragment;
import com.example.hgjoke.http.HTTP;
import com.example.hgjoke.utils.EB;
import com.example.hgjoke.utils.SP;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author:hm
 * Date:2019/9/28
 */
public class MainActivity extends BaseActivity {
    private SP sp = new SP();
    @BindView(R.id.vp_main)
    ViewPager mVp;
    @BindView(R.id.rg_main)
    RadioGroup mRg;
    @BindView(R.id.rb_item1)
    RadioButton mRb1;
    @BindView(R.id.rb_item2)
    RadioButton mRb2;
    @BindView(R.id.rb_item3)
    RadioButton mRb3;
    @BindView(R.id.rb_item4)
    RadioButton mRb4;
    private List<Fragment> mFragment = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
        initListener();
    }
    private void initView() {
        rxDestroy(HTTP.TestMy("黄明")).subscribe(model->{

        },e->{
            e.printStackTrace();
        });
        EB.register(this);
        mFragment.add(new HomeFragment());
        mFragment.add(new ClassFragment());
        mFragment.add(new CarFragment());
        mFragment.add(new MeFragment());
        mVp.setOffscreenPageLimit(mFragment.size());
        mVp.setAdapter(new MainFragmentAdapter(getSupportFragmentManager(), mFragment));
    }
    private void initListener() {
        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        mRb1.setChecked(true);
                        break;
                    case 1:
                        mRb2.setChecked(true);
                        break;
                    case 2:
                        mRb3.setChecked(true);
                        break;
                    case 3:
                        mRb4.setChecked(true);
                        break;
                    default:
                        mRb1.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mRg.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_item1:
                    mVp.setCurrentItem(0);
                    break;
                case R.id.rb_item2:
                    mVp.setCurrentItem(1);
                    break;
                case R.id.rb_item3:
                    mVp.setCurrentItem(2);
                    break;
                case R.id.rb_item4:
                    mVp.setCurrentItem(3);
                    break;
            }
        });
    }
    @Subscribe
    public void onEvent(EBData data) {
        switch (data.getType()) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EB.unregister(this);
    }

}
