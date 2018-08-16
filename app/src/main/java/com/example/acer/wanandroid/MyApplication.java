package com.example.acer.wanandroid;

import android.app.Application;

import com.example.acer.wanandroid.net.RetrofitClient;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化Retrofit
        RetrofitClient.getInstance(getApplicationContext()).initRetrofit();

    }


}
