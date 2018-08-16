package com.example.acer.wanandroid;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

import it.sephiroth.android.library.picasso.Picasso;

public class PicassoImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Picasso.with(context.getApplicationContext()).load((String) path).into(imageView);
    }
}
