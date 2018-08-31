package com.example.acer.wanandroid.ui;

import android.database.Observable;
import android.databinding.DataBindingUtil;
import android.icu.util.TimeUnit;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TimeUtils;
import android.widget.FrameLayout;

import com.example.acer.wanandroid.Adapter.MyViewpagerAdapter;
import com.example.acer.wanandroid.R;
import com.example.acer.wanandroid.bean.BannerBean;
import com.example.acer.wanandroid.bean.FragmentHomeData;
import com.example.acer.wanandroid.bean.HomeSubData;
import com.example.acer.wanandroid.databinding.ActivityMainBinding;
import com.example.acer.wanandroid.net.NetResult;
import com.example.acer.wanandroid.net.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class MainActivity extends FragmentActivity {

    private ActivityMainBinding activityMainBinding;
    private SplashFragment splashFragment;
    private HomeFragment homeFragment;
    private FragmentTransaction transaction;

    private List<HomeSubData> mResult;

    private Handler handler = new Handler();
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        splashFragment = new SplashFragment();
        homeFragment = new HomeFragment();
        changeFragment(homeFragment);

//        getWindow().getDecorView().post(new Runnable() {
//            @Override
//            public void run() {
//                // 开启延迟加载
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        changeFragment(homeFragment);
//                    }
//                }, 2000);
//            }
//        });


    }


    private void changeFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.layout_frame, fragment);
        transaction.commit();
    }



    public List<HomeSubData> getResult() {
        if (mResult != null && mResult.size() != 0) {
            return mResult;
        }

        return null;
    }

}
