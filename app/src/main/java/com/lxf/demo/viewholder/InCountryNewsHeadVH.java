package com.lxf.demo.viewholder;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lxf.demo.R;

/**
 * Created by LiuXiaoFeng on 2016/7/14.
 *  国内新闻页recyclerView头条目的viewHolder
 */
public class InCountryNewsHeadVH extends RecyclerView.ViewHolder{

    public ViewPager viewPager;

    public InCountryNewsHeadVH(View itemView) {
        super(itemView);
        initView();
    }

    private void initView(){
        viewPager = ((ViewPager) itemView.findViewById(R.id.incountry_pager_headviewpager));
    }
}
