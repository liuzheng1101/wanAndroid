package com.example.acer.wanandroid.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.acer.wanandroid.Adapter.MyViewpagerAdapter;
import com.example.acer.wanandroid.R;
import com.example.acer.wanandroid.bean.BannerBean;
import com.example.acer.wanandroid.databinding.ActivityMainBinding;
import com.example.acer.wanandroid.net.NetResult;
import com.example.acer.wanandroid.net.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        HomeFragment fragment = new HomeFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager. beginTransaction();
        transaction.replace(R.id.layout_frame, fragment);
        transaction.commit();
    }
}
