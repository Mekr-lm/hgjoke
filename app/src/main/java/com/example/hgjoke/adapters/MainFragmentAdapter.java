package com.example.hgjoke.adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * author:hm
 * Date:2019/9/28
 */

public class MainFragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mList;

    public MainFragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return null == mList ? 0 : mList.size();
    }
}
