package com.example.hgjoke.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hgjoke.App;
import com.example.hgjoke.R;
import com.example.hgjoke.activity.ClassActivity;
import com.example.hgjoke.activity.ClassSearchActivity;
import com.example.hgjoke.adapters.GridIconAdapter;
import com.example.hgjoke.adapters.ShopClassAdapter;
import com.example.hgjoke.entitys.GridIconInfo;
import com.example.hgjoke.entitys.ShopListInfo;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author:hm
 * Date:2019/11/8
 */
public class ClassFragment extends BaseFragment implements View.OnClickListener{
    @BindView(R.id.shop_xr)
    XRecyclerView mXrShop;
    @BindView(R.id.grid_icon_view)
    GridView grid_photo;
    @BindView(R.id.iv_home_search)
    TextView ClassSearch;
    private ShopClassAdapter mAdp;
    @Override
    protected int getLayoutID() {
        return R.layout.fragment_class;
    }

    @Override
    protected void init(View view, Bundle savedInstanceState) {
        initView();
        initListener();
    }
    public void initView(){
        LinearLayout.LayoutParams mXr = (LinearLayout.LayoutParams) mXrShop.getLayoutParams();
        mXr.height = App.h;
        mXrShop.setLayoutParams(mXr);
        LinearLayoutManager linear = new LinearLayoutManager(mContext){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        mXrShop.setLayoutManager(linear);
        mXrShop.setPullRefreshEnabled(false);
        mXrShop.setLoadingMoreEnabled(false);
        mAdp = new ShopClassAdapter(mContext,this);
        mXrShop.setAdapter(mAdp);

        List<ShopListInfo> list = new ArrayList<>();
        list.add(new ShopListInfo("专业安卓脚本定制开发","一个属于每个互联网行业的APP","千万起"));
        list.add(new ShopListInfo("专业安卓脚本定制开发","一个属于每个互联网行业的APP","千万起"));
        list.add(new ShopListInfo("专业安卓脚本定制开发","一个属于每个互联网行业的APP","千万起"));
        list.add(new ShopListInfo("专业安卓脚本定制开发","一个属于每个互联网行业的APP","千万起"));
        list.add(new ShopListInfo("专业安卓脚本定制开发","一个属于每个互联网行业的APP","千万起"));
        list.add(new ShopListInfo("专业安卓脚本定制开发","一个属于每个互联网行业的APP","千万起"));
        mAdp.setmList(list);
        mAdp.notifyDataSetChanged();

        ArrayList<GridIconInfo> mData = new ArrayList<>();
        mData.add(new GridIconInfo(R.mipmap.hairdressing,"小程序"));
        mData.add(new GridIconInfo(R.mipmap.hairdressing,"安卓"));
        mData.add(new GridIconInfo(R.mipmap.hairdressing,"苹果"));
        mData.add(new GridIconInfo(R.mipmap.hairdressing,"移动端"));
        mData.add(new GridIconInfo(R.mipmap.hairdressing,"网页"));
        mData.add(new GridIconInfo(R.mipmap.hairdressing,"后台"));
        mData.add(new GridIconInfo(R.mipmap.hairdressing,"java"));
        mData.add(new GridIconInfo(R.mipmap.hairdressing,"C++"));
        mData.add(new GridIconInfo(R.mipmap.hairdressing,".net"));
        mData.add(new GridIconInfo(R.mipmap.hairdressing,"其他"));
        BaseAdapter GridAdp = new GridIconAdapter<GridIconInfo>(mData, R.layout.item_grid_icon) {
            @Override
            public void bindView(GridIconAdapter.ViewHolder holder, GridIconInfo obj) {
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };
        grid_photo.setAdapter(GridAdp);
        grid_photo.setOnItemClickListener((parent, view, position, id) ->{
                startActivity(new Intent(mContext, ClassActivity.class));
                }
        );
        ClassSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, ClassSearchActivity.class));
            }
        });
    }
    public void initListener(){

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }
}
