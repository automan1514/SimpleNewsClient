package com.lxf.demo.pager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lxf.demo.R;
import com.lxf.demo.adapter.RecyclerViewAdapter;
import com.lxf.demo.bean.InCountryNewsHeadBean;
import com.lxf.demo.bean.InCountryNewsItemBean;

import java.util.AbstractList;
import java.util.ArrayList;

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
        //给一些假数据
        ArrayList testData = createSomeTestData();

        recyclerViewAdapter = new RecyclerViewAdapter(context,testData);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    /**
     * 临时方法，用于生产测试数据
     * @return
     */
    private ArrayList createSomeTestData(){
        ArrayList data = new ArrayList();

        ArrayList<ImageView> imgs = new ArrayList<>();
        for(int i=0;i<4;i++){
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(R.drawable.test);
            imgs.add(imageView);
        }

        //国内新闻页头图区域要展示的数据
        InCountryNewsHeadBean inCountryNewsHeadBean = new InCountryNewsHeadBean();
        inCountryNewsHeadBean.imgs=imgs;
        data.add(inCountryNewsHeadBean);

        //国内新闻页条目区域要展示的数据
        for(int i=0;i<20;i++){
            InCountryNewsItemBean inCountryNewsItemBean = new InCountryNewsItemBean();
            data.add(inCountryNewsItemBean);
        }

        return data;
    }
}
