package com.example.acer.wanandroid.net;

public interface NetResult<T> {


    void onSuccess(T result);

    void onFail();
}
