package com.example.shenxuesong.zhousanmoli0918.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shenxuesong.zhousanmoli0918.Adapter.MyAdapter;
import com.example.shenxuesong.zhousanmoli0918.JavaBean;
import com.example.shenxuesong.zhousanmoli0918.JavaDao;
import com.example.shenxuesong.zhousanmoli0918.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by shenxuesong on 2017/9/18.
 */

public class NewFragment extends Fragment {
    private PullToRefreshListView lv;
    //http://gank.io/api/data/Android/10/1
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.newfragment_layout, container, false);

        lv=(PullToRefreshListView)view.findViewById(R.id.pull_refresh_list);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //接收Fragment01传来的值
        String st = getArguments().getString("name");
        try {
            String ff = URLEncoder.encode(st, "utf-8");
            //解析gson
            jiexi(ff);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }




    }

    private void jiexi(final String ff) {
        new AsyncTask<String,Integer,String>(){
            @Override
            protected String doInBackground(String... strings) {
                String sm="http://gank.io/api/data/"+ff+"/10/1";
                String s = new JavaDao().getString(sm);
                return s;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                List<JavaBean.ResultsBean> results = new Gson().fromJson(s, JavaBean.class).getResults();

                MyAdapter myAdapter = new MyAdapter(results, getActivity());
                lv.setAdapter(myAdapter);

            }
        }.execute();
    }
}
