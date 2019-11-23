package com.example.hgjoke.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;

import com.example.hgjoke.R;
import com.example.hgjoke.adapters.ShopClassAdapter;
import com.example.hgjoke.entitys.ShopListInfo;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CommodityListFragment extends BaseFragment {

    @BindView(R.id.rv_commodity_list)
    XRecyclerView mRv;
    private ShopClassAdapter mAdp;

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

        mAdp = new ShopClassAdapter(mContext,this);
        mRv.setAdapter(mAdp);

        List<ShopListInfo> list = new ArrayList<>();
        list.add(new ShopListInfo("专业安卓脚本定制开发","一个属于每个互联网行业的APP","千万起"));
        list.add(new ShopListInfo("专业安卓脚本定制开发","一个属于每个互联网行业的APP","千万起"));
        list.add(new ShopListInfo("专业安卓脚本定制开发","一个属于每个互联网行业的APP","千万起"));
        list.add(new ShopListInfo("专业安卓脚本定制开发","一个属于每个互联网行业的APP","千万起"));
        mAdp.setmList(list);
        mAdp.notifyDataSetChanged();



    }


}
