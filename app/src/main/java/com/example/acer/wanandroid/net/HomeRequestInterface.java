package com.example.acer.wanandroid.net;

import com.example.acer.wanandroid.bean.BannerBean;
import com.example.acer.wanandroid.bean.FragmentHomeData;
import com.example.acer.wanandroid.bean.HomeData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HomeRequestInterface {

    @GET("banner/json")
    Observable<BannerBean> getBanner();

    @GET("article/list/{page}/json")
    Observable<FragmentHomeData> getHomeData(@Path("page") int page);

}
