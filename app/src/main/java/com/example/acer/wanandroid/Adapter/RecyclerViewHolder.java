package com.example.acer.wanandroid.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.acer.wanandroid.databinding.ItemHomeRecyclerviewBinding;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {


    ItemHomeRecyclerviewBinding itemHomeRecyclerviewBinding;
    public RecyclerViewHolder(ItemHomeRecyclerviewBinding itemHomeRecyclerviewBinding) {
        super(itemHomeRecyclerviewBinding.getRoot());

        this.itemHomeRecyclerviewBinding = itemHomeRecyclerviewBinding;
    }

    public ItemHomeRecyclerviewBinding getItemHomeRecyclerviewBinding() {
        return itemHomeRecyclerviewBinding;
    }

    public void setItemHomeRecyclerviewBinding(ItemHomeRecyclerviewBinding itemHomeRecyclerviewBinding) {
        this.itemHomeRecyclerviewBinding = itemHomeRecyclerviewBinding;
    }
}
