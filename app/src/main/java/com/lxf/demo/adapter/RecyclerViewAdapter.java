package com.lxf.demo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxf.demo.R;
import com.lxf.demo.viewholder.InCountryNewsItemVH;

/**
 * Created by LiuXiaoFeng on 2016/7/13.
 * recyclerView所使用的适配器
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<InCountryNewsItemVH>{

    @Override
    public InCountryNewsItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview_incountrynews, parent, false);
        return new InCountryNewsItemVH(view);
    }

    @Override
    public void onBindViewHolder(InCountryNewsItemVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 40;
    }
}
