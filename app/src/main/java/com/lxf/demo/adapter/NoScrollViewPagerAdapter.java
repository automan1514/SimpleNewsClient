package com.lxf.demo.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.lxf.demo.pager.NewsListBasePager;

import java.util.ArrayList;

/**
 * Created by LiuXiaoFeng on 2016/7/13.
 * 不能进行手势滑动的ViewPager所使用的适配器
 */
public class NoScrollViewPagerAdapter extends PagerAdapter{

    private ArrayList<NewsListBasePager> pagers;

    /**
     * @param pagers 注意，参数的size必须为4！
     */
    public NoScrollViewPagerAdapter(ArrayList<NewsListBasePager> pagers){
        this.pagers=pagers;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View rootView = ((NewsListBasePager) pagers.get(position)).rootView;
        container.addView(rootView);
        return rootView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
