package com.example.shenxuesong.zhousanmoli0918;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by shenxuesong on 2017/9/18.
 */

public class JavaDao {
    public String getString(String surl){
        String str="";
        try {

            URL url = new URL(surl);
            HttpURLConnection http=(HttpURLConnection)url.openConnection();
            http.setReadTimeout(2000);
            http.setConnectTimeout(2000);
            int code = http.getResponseCode();
            if(code==200){
                InputStream in = http.getInputStream();
                byte[] b=new byte[1024];
                int len=0;
                while((len=in.read(b))!=-1){
                    str+=new String(b,0,len);
                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
