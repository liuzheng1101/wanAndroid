package com.example.acer.wanandroid.bean;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;


public class BannerBean {

    private List<SubBannerBean> data;
    private int errorCode;
    private String errorMsg;

    public List<SubBannerBean> getData() {
        return data;
    }

    public void setData(List<SubBannerBean> data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "BannerBean{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
