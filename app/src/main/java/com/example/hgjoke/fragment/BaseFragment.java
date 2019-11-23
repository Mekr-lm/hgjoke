package com.example.hgjoke.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hgjoke.R;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;

/**
 * author:hm
 * Date:2019/9/28
 */
public abstract class BaseFragment extends RxFragment {
    public Activity mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayoutID(), container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = this.getActivity();
        ButterKnife.bind(this, view);
        init(view, savedInstanceState);
    }

    public void setTitleText(View v, String title) {
        try {
            ((TextView) v.findViewById(R.id.tv_title_text)).setText(title);
        } catch (Exception e) {
        }
    }

    //======================================

    /**
     * 获取Fragment布局ID
     *
     * @return 布局ID
     */
    protected abstract int getLayoutID();

    /**
     * 初始化完成，替代{@link #onViewCreated(View, Bundle)}
     */
    protected abstract void init(View view, Bundle savedInstanceState);


}