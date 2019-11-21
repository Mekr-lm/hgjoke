package com.example.hgjoke.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hgjoke.App;
import com.example.hgjoke.R;
import com.example.hgjoke.adapters.FServerAdapter;
import com.example.hgjoke.adapters.GlideImageLoader;
import com.example.hgjoke.adapters.GridIconAdapter;
import com.example.hgjoke.adapters.ShopRecommendAdapter;
import com.example.hgjoke.entitys.BannerInfo;
import com.example.hgjoke.entitys.FServerInfo;
import com.example.hgjoke.entitys.GridIconInfo;
import com.example.hgjoke.entitys.ShopInfo;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author:hm
 * Date:2019/11/8
 */
public class HomeFragment extends BaseFragment{
    @BindView(R.id.bn_home_top)
    Banner mBanner;
    @BindView(R.id.rv_server_list)
    XRecyclerView mXrServer;
    @BindView(R.id.grid_icon_view)
    GridView grid_photo;
    @BindView(R.id.rv_home_list)
    RecyclerView mRv;
    private FServerAdapter mAdServer;
    private int page = 1;
    private List<BannerInfo> mLtBanner;
    private ShopRecommendAdapter mAdp;
    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(View view, Bundle savedInstanceState) {
        initView();
        initListener();
        initData();
    }
    public void initView(){
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mBanner.getLayoutParams();
        params.height = (App.w / 2);
        mBanner.setLayoutParams(params);
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setDelayTime(6000);
        mLtBanner = new ArrayList<>();
        mLtBanner.add(new BannerInfo());
        mLtBanner.add(new BannerInfo());
        mBanner.setImages(mLtBanner);
        mBanner.start();

        LinearLayout.LayoutParams mXr = (LinearLayout.LayoutParams) mXrServer.getLayoutParams();
        mXr.height = App.h;
        mXrServer.setLayoutParams(mXr);
        LinearLayoutManager linear = new LinearLayoutManager(mContext){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        mXrServer.setLayoutManager(linear);
        mXrServer.setPullRefreshEnabled(false);
        mXrServer.setLoadingMoreEnabled(false);
        mAdServer = new FServerAdapter(mContext,this);
        mXrServer.setAdapter(mAdServer);


        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 1);
        layoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        mRv.setLayoutManager(layoutManager);
        mRv.setNestedScrollingEnabled(false);
        mAdp = new ShopRecommendAdapter(mContext,this);
        mRv.setAdapter(mAdp);
        List<ShopInfo> list = new ArrayList<>();
        list.add(new ShopInfo("明辉计算机软件","一个属于所有从事互联网行业的APP"));
        list.add(new ShopInfo("明辉计算机软件","一个属于所有从事互联网行业的APP"));
        list.add(new ShopInfo("明辉计算机软件","一个属于所有从事互联网行业的APP"));
        list.add(new ShopInfo("明辉计算机软件","一个属于所有从事互联网行业的APP"));
        list.add(new ShopInfo("明辉计算机软件","一个属于所有从事互联网行业的APP"));
        mAdp.setmList(list);
        mAdp.notifyDataSetChanged();
    }
    public void initListener(){
        mXrServer.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mXrServer.postDelayed(() -> {

                    mXrServer.refreshComplete();
                }, 1200);
            }

            @Override
            public void onLoadMore() {
                page++;
                mXrServer.postDelayed(() -> {

                    mXrServer.loadMoreComplete();
                }, 1200);
            }
        });

    }
    public void initData(){
        addData();
    }

    public void addData(){
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
        mAdServer.setmList(list);
        mAdServer.notifyDataSetChanged();


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
            public void bindView(ViewHolder holder, GridIconInfo obj) {
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };
        grid_photo.setAdapter(GridAdp);
        grid_photo.setOnItemClickListener((parent, view, position, id) ->{

                }
        );
    }
}

