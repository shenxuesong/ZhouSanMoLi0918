package com.example.shenxuesong.zhousanmoli0918.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by shenxuesong on 2017/9/18.
 */

public class MyAdapter1 extends FragmentPagerAdapter {
    private List<Fragment> list;

    public MyAdapter1(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }
}
