package com.lxf.demo.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by LiuXiaoFeng on 2016/7/14.
 * 国内新闻页头图区域所使用的适配器
 */
public class HeadImgAdapter extends PagerAdapter{
    private ArrayList<ImageView> imgs;

    public HeadImgAdapter(ArrayList<ImageView> imgs){
        super();
        this.imgs=imgs;
    }

    @Override
    public int getCount() {
        return imgs.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = (ImageView) imgs.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
