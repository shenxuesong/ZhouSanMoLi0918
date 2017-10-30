package com.example.shenxuesong.zhousanmoli0918;

import android.app.Application;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by shenxuesong on 2017/9/18.
 */

public class MyAppliction extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration con=new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(getoptin())
                .build();
        ImageLoader.getInstance().init(con);
    }
    public DisplayImageOptions getoptin(){
        DisplayImageOptions options=new DisplayImageOptions.Builder()
                //配置图片的色彩模式为RGB565
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        return options;
    }
}
