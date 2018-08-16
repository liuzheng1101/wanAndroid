package com.example.acer.wanandroid.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.example.acer.wanandroid.R;

import java.util.List;

import com.example.acer.wanandroid.bean.BannerBean;
import com.example.acer.wanandroid.databinding.ItemViewpagerBinding;

/**
 * 主页banner适配器
 *
 * @author lz
 */
public class MyViewpagerAdapter extends PagerAdapter {

    /**
     * 图片地址集合
     */
    private List<String> list;
    private LayoutInflater inflater;
    private Context context;
    private ItemViewpagerBinding itemViewpagerBinding;

    public MyViewpagerAdapter(Context context, List<String> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        itemViewpagerBinding = DataBindingUtil.inflate(inflater, R.layout.item_viewpager, container, false);
        ImageView bannerView = itemViewpagerBinding.ivBanner;
        ViewGroup group = (ViewGroup) bannerView.getParent();
        if (group != null) {
            group.removeAllViews();
        }

//        BannerBean.getImage(bannerView, list.get(position));
        container.addView(bannerView, 0);
        return bannerView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }
}
