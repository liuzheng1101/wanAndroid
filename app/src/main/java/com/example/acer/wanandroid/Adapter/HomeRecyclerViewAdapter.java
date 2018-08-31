package com.example.acer.wanandroid.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acer.wanandroid.R;
import com.example.acer.wanandroid.bean.HomeSubData;
import com.example.acer.wanandroid.databinding.ItemHomeRecyclerviewBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lz
 *
 */
public class HomeRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<T> list;
    private LayoutInflater inflater;
    private Context context;
    private int mVariableId;
    private int layoutId;

    public HomeRecyclerViewAdapter(Context context, List<T> list, LayoutInflater inflater, int mVariableId, int layoutId) {
        this.context = context;
        this.list = list;
        this.inflater = inflater;
        this.mVariableId = mVariableId;
        this.layoutId = layoutId;
    }

    /**
     * 用于模仿listview的itemclick事件，recyclerview没有itemclick
     */
    private OnItemClickListener mOnItemClickListener;


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ItemHomeRecyclerviewBinding itemHomeRecyclerviewBinding
                = DataBindingUtil.inflate(inflater, layoutId, viewGroup, false);

        return new RecyclerViewHolder(itemHomeRecyclerviewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int position) {
        ItemHomeRecyclerviewBinding itemHomeRecyclerviewBinding
                = recyclerViewHolder.getItemHomeRecyclerviewBinding();

        itemHomeRecyclerviewBinding.getRoot().setTag(position);
        itemHomeRecyclerviewBinding.getRoot().setOnClickListener(new OnCradViewClickListener(position));

        T homeSubData = list.get(position);
        itemHomeRecyclerviewBinding.setVariable(mVariableId, homeSubData);
        itemHomeRecyclerviewBinding.executePendingBindings();
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    private class OnCradViewClickListener implements View.OnClickListener {

        private int position;

        public OnCradViewClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            mOnItemClickListener.onItemClick(view, position);
        }
    }


}
