package com.lxf.demo.pager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lxf.demo.R;
import com.lxf.demo.adapter.RecyclerViewAdapter;

/**
 * Created by LiuXiaoFeng on 2016/7/13.
 * 国内新闻对应的pager
 */
public class InCountryPager extends NewsListBasePager{

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    public InCountryPager(Context context,View rootView) {
        super(context,rootView);
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.incountry_pager_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public void initData() {
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
