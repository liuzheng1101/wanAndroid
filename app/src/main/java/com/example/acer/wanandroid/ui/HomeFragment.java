package com.example.acer.wanandroid.ui;

import android.app.Fragment;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.example.acer.wanandroid.Adapter.HomeRecyclerViewAdapter;
import com.example.acer.wanandroid.R;
import com.example.acer.wanandroid.bean.FragmentHomeData;
import com.example.acer.wanandroid.bean.HomeSubData;
import com.example.acer.wanandroid.net.NetResult;
import com.example.acer.wanandroid.net.RetrofitClient;
import com.example.acer.wanandroid.databinding.FragmentHomeBinding;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<HomeSubData> list;
    private FragmentHomeBinding fragmentHomeBinding;
    private HomeRecyclerViewAdapter adapter;
    private Context context;
    private int page;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentHomeBinding = DataBindingUtil.inflate(inflater
                , R.layout.fragment_home, container, false);
        View rootView = fragmentHomeBinding.getRoot();
        init();

        SmartRefreshLayout smartRefreshLayout = rootView.findViewById(R.id.refreshLayout);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(1500);
                getInitData(++page, new NetResult<List<HomeSubData>>() {
                    @Override
                    public void onSuccess(List<HomeSubData> result) {
                        list.addAll(0, result);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFail() {

                    }
                });
            }
        });

        return rootView;
    }

    /**
     * 获取列表数据
     *
     * @param page      页码
     * @param netResult 返回请求状态接口
     */
    private void getInitData(int page, final NetResult<List<HomeSubData>> netResult) {


        RetrofitClient.getInstance(context).getHomeData(new NetResult<FragmentHomeData>() {

            @Override
            public void onSuccess(FragmentHomeData result) {
                netResult.onSuccess(result.getData().getDatas());
            }

            @Override
            public void onFail() {

            }
        }, page);


    }

    /**
     * 初始化相关数据
     */
    private void init() {
        context = getActivity().getApplicationContext();
        list = new ArrayList<>();
        page = 1;

        // 获取首页数据
        getInitData(page, new NetResult<List<HomeSubData>>() {
            @Override
            public void onSuccess(List<HomeSubData> result) {
                list.addAll(0, result);
                fragmentHomeBinding.homeRecyclerView.setLayoutManager(new LinearLayoutManager(context
                        , LinearLayoutManager.VERTICAL, false));
                adapter = new HomeRecyclerViewAdapter<HomeSubData>(context, list, LayoutInflater.from(context)
                        , BR.homesubdata, R.layout.item_home_recyclerview);
                fragmentHomeBinding.homeRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFail() {

            }
        });
    }
}
