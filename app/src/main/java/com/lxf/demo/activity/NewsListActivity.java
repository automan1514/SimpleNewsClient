package com.lxf.demo.activity;

import android.animation.FloatArrayEvaluator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lxf.demo.R;
import com.lxf.demo.adapter.NoScrollViewPagerAdapter;
import com.lxf.demo.customview.NoScrollViewPager;
import com.lxf.demo.pager.CarePager;
import com.lxf.demo.pager.InCountryPager;
import com.lxf.demo.pager.MinePager;
import com.lxf.demo.pager.NewsListBasePager;
import com.lxf.demo.pager.OutCountryPager;

import java.util.ArrayList;

/**
 * Created by LiuXiaoFeng on 2016/7/13.
 * 新闻列表页
 */
public class NewsListActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener {

    private NoScrollViewPager viewPager;
    private RadioGroup radioGroup;
    private InCountryPager inCountryPager;
    private OutCountryPager outCountryPager;
    private CarePager carePager;
    private MinePager minePager;
    private ArrayList<NewsListBasePager> pagers;
    private NoScrollViewPagerAdapter noScrollViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newslist);
        initView();
        initData();
        initListener();
    }
    
    private void initView(){
        viewPager = (NoScrollViewPager) findViewById(R.id.newslist_viewpager);
        radioGroup = (RadioGroup) findViewById(R.id.newslist_bottom_radiogroup);
    }

    private void initData(){

        //先拿到4个pager页面对应的根视图
        View inCountryRootView = LayoutInflater.from(getActivity()).inflate(R.layout.pager_incountry,null);
        View outCountryRootView = LayoutInflater.from(getActivity()).inflate(R.layout.pager_outcountry,null);
        View careRootView = LayoutInflater.from(getActivity()).inflate(R.layout.pager_care,null);
        View mineRootView = LayoutInflater.from(getActivity()).inflate(R.layout.pager_mine,null);

        //把根视图交由对应的pager管理
        inCountryPager = new InCountryPager(getActivity(),inCountryRootView);
        outCountryPager = new OutCountryPager(getActivity(),outCountryRootView);
        carePager = new CarePager(getActivity(),careRootView);
        minePager = new MinePager(getActivity(),mineRootView);

        //把4个pager塞进pagers集合，并将pagers集合交由适配器管理
        pagers = new ArrayList<NewsListBasePager>();
        pagers.add(inCountryPager);
        pagers.add(outCountryPager);
        pagers.add(carePager);
        pagers.add(minePager);
        noScrollViewPagerAdapter = new NoScrollViewPagerAdapter(pagers);

        //给viewPager设置适配器，展示视图内容
        viewPager.setAdapter(noScrollViewPagerAdapter);
    }

    private void initListener(){
        radioGroup.setOnCheckedChangeListener(this);
        viewPager.addOnPageChangeListener(this);
    }

    /**
     * 底栏radioGroup选择状态发生变化时的回调
     * @param group      底栏的radipGroup
     * @param checkedId  被选中的radioBtn的id
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.newslist_bottom_radiobtn_incountry:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.newslist_bottom_radiobtn_outcountry:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.newslist_bottom_radiobtn_care:
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.newslist_bottom_radiobtn_mine:
                viewPager.setCurrentItem(3,false);
                break;
            default:
                break;
        }
    }


    /**
     *viewPager滑动时的回调
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * ViewPager滑动完成后的回调
     */
    @Override
    public void onPageSelected(int position) {
        ((NewsListBasePager) pagers.get(position)).initView();
        ((NewsListBasePager) pagers.get(position)).initData();
    }

    /**
     *viewPager滑动状态发生改变时的回调
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
