package com.example.acer.wanandroid.net;

import android.content.Context;

import com.example.acer.wanandroid.bean.BannerBean;
import com.example.acer.wanandroid.bean.FragmentHomeData;
import com.example.acer.wanandroid.bean.HomeData;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitClient网络访问类
 *
 * @author lz
 */
public class RetrofitClient {


    private static volatile RetrofitClient retrofitClient;
    private Context context;
    private Retrofit retrofit;

    private RetrofitClient(Context context) {
        this.context = context;
    }

    public static RetrofitClient getInstance(Context context) {

        if (retrofitClient == null) {

            synchronized (RetrofitClient.class) {

                if (retrofitClient == null) {
                    retrofitClient = new RetrofitClient(context);
                }
            }
        }
        return retrofitClient;
    }

    public void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    public void getBannerInfo(final NetResult<BannerBean> netResult) {

        HomeRequestInterface homeRequestInterface = retrofit.create(HomeRequestInterface.class);

        Observable<BannerBean> bannerObservable = homeRequestInterface.getBanner();

        bannerObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        netResult.onSuccess(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        netResult.onFail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getHomeData(final NetResult<FragmentHomeData> homeDataNetResult, int page) {

        HomeRequestInterface homeRequestInterface = retrofit.create(HomeRequestInterface.class);

        Observable<FragmentHomeData> homeDataObservable = homeRequestInterface.getHomeData(page);

        homeDataObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FragmentHomeData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FragmentHomeData fragmentHomeData) {
                        homeDataNetResult.onSuccess(fragmentHomeData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeDataNetResult.onFail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }


}
