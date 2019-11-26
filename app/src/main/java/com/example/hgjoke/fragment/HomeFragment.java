package com.example.hgjoke.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hgjoke.App;
import com.example.hgjoke.R;
import com.example.hgjoke.activity.ClassPublishActivity;
import com.example.hgjoke.activity.HomePublishActivity;
import com.example.hgjoke.activity.HomeSearchActivity;
import com.example.hgjoke.adapters.FServerAdapter;
import com.example.hgjoke.adapters.GlideImageLoader;
import com.example.hgjoke.adapters.ShopRecommendAdapter;
import com.example.hgjoke.entitys.BannerInfo;
import com.example.hgjoke.entitys.FServerInfo;
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
public class HomeFragment extends BaseFragment implements View.OnClickListener{
    @BindView(R.id.bn_home_top)
    Banner mBanner;
    @BindView(R.id.rv_server_list)
    XRecyclerView mXrServer;
    @BindView(R.id.rv_home_list)
    RecyclerView mRv;
    @BindView(R.id.iv_home_search)
    TextView homeSearch;
    @BindView(R.id.publish)
    TextView publish;
    @BindView(R.id.publish_shop)
    TextView publishShop;
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
        publish.setOnClickListener(this);
        publishShop.setOnClickListener(this);
        homeSearch.setOnClickListener(this);
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


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_home_search:
                startActivity(new Intent(mContext, HomeSearchActivity.class));
                break;
            case R.id.publish:
                startActivity(new Intent(mContext, HomePublishActivity.class));
                break;
            case R.id.publish_shop:
                startActivity(new Intent(mContext, ClassPublishActivity.class));
                break;
        }
    }
}

