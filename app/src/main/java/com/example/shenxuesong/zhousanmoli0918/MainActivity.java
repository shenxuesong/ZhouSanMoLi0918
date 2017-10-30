package com.example.shenxuesong.zhousanmoli0918;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.shenxuesong.zhousanmoli0918.Adapter.MyAdapter1;
import com.example.shenxuesong.zhousanmoli0918.Fragment.Fragment01;
import com.example.shenxuesong.zhousanmoli0918.Fragment.Fragment02;
import com.example.shenxuesong.zhousanmoli0918.Fragment.Fragment03;
import com.example.shenxuesong.zhousanmoli0918.Fragment.Fragment04;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private ViewPager vp;
    private RadioGroup rg;
    private List<Fragment> list = new ArrayList<Fragment>();
    private Fragment01 fragment01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //查找组件
        vp = (ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);
        //造数据
        list.add(new Fragment01());
        list.add(new Fragment02());
        list.add(new Fragment03());
        list.add(new Fragment04());
        //设置适配器
        MyAdapter1 myAdapter = new MyAdapter1(getSupportFragmentManager(), list);
        vp.setAdapter(myAdapter);


        //设置viewpager的监听事件，使vp与rg有联动效果
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rg.check(R.id.rb1);
                        break;
                    case 1:
                        rg.check(R.id.rb2);
                        break;
                    case 2:
                        rg.check(R.id.rb3);
                        break;
                    case 3:
                        rg.check(R.id.rb4);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg.setOnCheckedChangeListener(this);

        fragment01 = new Fragment01();

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb1:
                vp.setCurrentItem(0);
                break;
            case R.id.rb2:
                vp.setCurrentItem(1);
                break;
            case R.id.rb3:
                vp.setCurrentItem(2);
                break;
            case R.id.rb4:
                vp.setCurrentItem(3);
                break;
        }
    }
}
