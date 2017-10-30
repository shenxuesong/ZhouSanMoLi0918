package com.example.shenxuesong.zhousanmoli0918.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shenxuesong.zhousanmoli0918.JavaBean;
import com.example.shenxuesong.zhousanmoli0918.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;

import java.util.List;

/**
 * Created by shenxuesong on 2017/9/18.
 */

public class MyAdapter extends BaseAdapter {
    private List<JavaBean.ResultsBean> list;
    private Context context;

    public MyAdapter(List<JavaBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder1 holder1=null;
        if(view==null){
            view=View.inflate(context, R.layout.item1,null);
            holder1=new ViewHolder1();
            holder1.image1=(ImageView)view.findViewById(R.id.image1);
            holder1.tv=(TextView)view.findViewById(R.id.tv) ;

            view.setTag(holder1);
        }else {
            holder1=(ViewHolder1)view.getTag();
        }
        String who = list.get(i).getWho();
        String type = list.get(i).getType();
        String url = list.get(i).getUrl();
        String createdAt = list.get(i).getCreatedAt();
      holder1.tv.setText(who+"\n"+type+"\n"+url+"\n"+createdAt);
        List<String> images = list.get(i).getImages();
        if(images!=null) {
            if(images.size()==1) {
                String s = images.get(0);
                ImageSize size=new ImageSize(100,100);
                ImageLoader.getInstance().displayImage(s + "?/imageView2/0/w/100", holder1.image1,size);
            }
        }
        return view;
    }
    class ViewHolder1{
        TextView tv;
        ImageView image1;
    }
}
