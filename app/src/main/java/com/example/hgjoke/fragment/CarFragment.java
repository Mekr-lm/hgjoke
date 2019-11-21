package com.example.hgjoke.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hgjoke.R;
import com.example.hgjoke.adapters.ShopCarAdapter;
import com.example.hgjoke.entitys.CarInfo;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author:hm
 * Date:2019/11/8
 */
public class CarFragment extends BaseFragment{
    @BindView(R.id.shop_xr)
    XRecyclerView mXrShop;
    private ShopCarAdapter mAdp;
    @Override
    protected int getLayoutID() {
        return R.layout.fragment_car;
    }

    @Override
    protected void init(View view, Bundle savedInstanceState) {
        LinearLayoutManager linear = new LinearLayoutManager(mContext){
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        mXrShop.setLayoutManager(linear);
        mXrShop.setPullRefreshEnabled(false);
        mXrShop.setLoadingMoreEnabled(false);
        mAdp = new ShopCarAdapter(mContext,this);
        mXrShop.setAdapter(mAdp);

        List<CarInfo> list = new ArrayList<>();
        list.add(new CarInfo("专业安卓脚本定制开发","一个属于每个互联网行业的APP","千万起"));
        list.add(new CarInfo("专业安卓脚本定制开发","一个属于每个互联网行业的APP","千万起"));
        list.add(new CarInfo("专业安卓脚本定制开发","一个属于每个互联网行业的APP","千万起"));
        list.add(new CarInfo("专业安卓脚本定制开发","一个属于每个互联网行业的APP","千万起"));
        mAdp.setmList(list);
        mAdp.notifyDataSetChanged();
    }
}
