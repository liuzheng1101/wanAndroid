package com.example.acer.wanandroid.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.android.databinding.library.baseAdapters.BR;

public class FragmentHomeData extends BaseObservable{

    private HomeData data;

    private int errorCode;

    private String errorMsg;

    @Bindable
    public HomeData getData() {
        return data;
    }

    public void setData(HomeData data) {
        this.data = data;
        notifyPropertyChanged(BR.data);
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
}
