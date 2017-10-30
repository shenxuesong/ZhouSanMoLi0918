package com.example.shenxuesong.zhousanmoli0918.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shenxuesong.zhousanmoli0918.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenxuesong on 2017/9/18.
 */

public class Fragment01 extends Fragment {
    private TabLayout tab;
    private ViewPager vp1;
    private List<String> list=new ArrayList<String>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01, container, false);
        //查找控件
        tab = (TabLayout) view.findViewById(R.id.table);
        vp1 = (ViewPager) view.findViewById(R.id.pager);
        //tab的标题
        list.add("关注");
        list.add("推荐");
        list.add("热点");
        list.add("科技");
        list.add("视频");
        list.add("数码");
        list.add("汽车");
        list.add("科技");
        list.add("财经");
        list.add("时尚");

        //tablayout和viewpager关联
        tab.setupWithViewPager(vp1);
        //设置viewpager适配器
        vp1.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {

            @Override
            public CharSequence getPageTitle(int position) {

                return list.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                //实例化一个Fragment加载Xlistview
                NewFragment  newfragment = new NewFragment();
                Bundle bundle = new Bundle();
                if(list.get(position).equals("关注")){
                    bundle.putString("name","all");
                }
                else
                if(list.get(position).equals("推荐")){
                    bundle.putString("name","Android");
                }
                else
                if(list.get(position).equals("热点")){
                    bundle.putString("name","休息视频");
                }
                else
                if(list.get(position).equals("科技")){
                    bundle.putString("name","拓展资源");
                }
                else
                if(list.get(position).equals("视频")){
                    bundle.putString("name","前端");
                }
                else
                if(list.get(position).equals("数码")){
                    bundle.putString("name","all");
                }
                else
                if(list.get(position).equals("汽车")){
                    bundle.putString("name","福利");
                }
                else
                if(list.get(position).equals("科技")){
                    bundle.putString("name","Android");
                }
                else
                if(list.get(position).equals("体育")){
                    bundle.putString("name","休息视频");
                }
                else
                if(list.get(position).equals("时尚")){
                    bundle.putString("name","all");
                }
                //activity与fragment 1.getset，2.接口回调，3.setArguments ,getAraguments
                newfragment.setArguments(bundle);
                //相当于加载了一个Fragment
                return newfragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        return view;
    }
}
