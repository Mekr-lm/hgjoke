package com.example.hgjoke.activity;

import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.example.hgjoke.R;
import com.example.hgjoke.fragment.CommodityListFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;

public class ClassActivity extends BaseActivity {
    @BindView(R.id.vp_class)
    ViewPager mVp;
    @BindView(R.id.tab_class_view)
    SmartTabLayout mStlTab;

    FragmentPagerItems.Creator creator;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_class;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
        initListener();
        initData();
    }
    public void initView(){
        setTitleText("找需求");
        creator = FragmentPagerItems.with(mContext);
    }
    public void initListener(){

    }
    public void initData(){
        creator.add("全部", CommodityListFragment.class);
        mVp.setAdapter(new FragmentPagerItemAdapter(getSupportFragmentManager(), creator.create()));
        mStlTab.setViewPager(mVp);
    }
}
