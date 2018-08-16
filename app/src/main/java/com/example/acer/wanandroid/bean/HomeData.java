package com.example.acer.wanandroid.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.example.acer.wanandroid.BR;

import java.util.List;

public class HomeData extends BaseObservable{

    private int curPage;

    private List<HomeSubData> datas;

    private int offset;

    private boolean over;

    private int pageCount;

    private int size;

    private int total;


    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    @Bindable
    public List<HomeSubData> getDatas() {
        return datas;
    }

    public void setDatas(List<HomeSubData> datas) {
        this.datas = datas;
        notifyPropertyChanged(BR.datas);
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
