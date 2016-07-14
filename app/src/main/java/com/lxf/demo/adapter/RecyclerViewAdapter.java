package com.lxf.demo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxf.demo.R;
import com.lxf.demo.activity.NewsDetailActivity;
import com.lxf.demo.bean.InCountryNewsHeadBean;
import com.lxf.demo.viewholder.InCountryNewsHeadVH;
import com.lxf.demo.viewholder.InCountryNewsItemVH;

import java.util.AbstractCollection;
import java.util.ArrayList;

/**
 * Created by LiuXiaoFeng on 2016/7/13.
 * recyclerView所使用的适配器
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter implements View.OnClickListener{

    private static final int TYPE_HEAD = 100;
    private static final int TYPE_ITEM = 101;

    private Context context;
    private ArrayList data = new ArrayList();

    public RecyclerViewAdapter(Context context,ArrayList data){
        super();
        this.context=context;
        this.data=data;
    }

    @Override
    public int getItemViewType(int position) {
        Object obj = data.get(position);
        if(obj instanceof InCountryNewsHeadBean)
            return TYPE_HEAD;
        else
            return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE_HEAD){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.headview_incountrynews, parent, false);
            return new InCountryNewsHeadVH(view);
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview_incountrynews, parent, false);
            return new InCountryNewsItemVH(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object obj = data.get(position);
        int itemViewType = getItemViewType(position);
        if(itemViewType==TYPE_HEAD){
            HeadImgAdapter headImgAdapter = new HeadImgAdapter(((InCountryNewsHeadBean) obj).imgs);
            ((InCountryNewsHeadVH) holder).viewPager.setAdapter(headImgAdapter);
        }else if(itemViewType==TYPE_ITEM){
            holder.itemView.setOnClickListener(this);
        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context,NewsDetailActivity.class);
        context.startActivity(intent);
    }
}
