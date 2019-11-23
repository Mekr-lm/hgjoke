package com.example.hgjoke.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;

import com.example.hgjoke.R;
import com.example.hgjoke.adapters.FServerAdapter;
import com.example.hgjoke.entitys.FServerInfo;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeListFragment extends BaseFragment {

    @BindView(R.id.rv_commodity_list)
    XRecyclerView mRv;
    private FServerAdapter mAdp;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_commodity_list;
    }

    @Override
    protected void init(View view, Bundle savedInstanceState) {
        initView();
    }

    private void initView() {

        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 1);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mRv.setLayoutManager(layoutManager);
        mRv.setPullRefreshEnabled(false);
        mRv.setLoadingMoreEnabled(false);

        mAdp = new FServerAdapter(mContext,this);
        mRv.setAdapter(mAdp);

        List<FServerInfo> list = new ArrayList<>();
        list.add(new FServerInfo(198,"客户","默默软件模拟点击软件开发，要求能维护一个月，要提供源码" +
                "默默软件模拟点击软件开发，要求能维护一个月，要提供源码" +
                "默默软件模拟点击软件开发，要求能维护一个月，要提供源码" +
                "默默软件模拟点击软件开发，要求能维护一个月，要提供源码" +
                "默默软件模拟点击软件开发，要求能维护一个月，要提供源码" +
                "默默软件模拟点击软件开发，要求能维护一个月，要提供源码","安卓脚本开发","2019-11-19",0));
        list.add(new FServerInfo(198,"客户","默默软件模拟点击软件开发，要求能维护一个月，要提供源码","安卓脚本开发","2019-11-19",0));
        list.add(new FServerInfo(198,"客户","默默软件模拟点击软件开发，要求能维护一个月，要提供源码","安卓脚本开发","2019-11-19",0));
        list.add(new FServerInfo(198,"客户","默默软件模拟点击软件开发，要求能维护一个月，要提供源码","安卓脚本开发","2019-11-19",0));
        mAdp.setmList(list);
        mAdp.notifyDataSetChanged();



    }

}
