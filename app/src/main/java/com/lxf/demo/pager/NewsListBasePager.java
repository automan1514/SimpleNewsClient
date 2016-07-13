package com.lxf.demo.pager;

import android.content.Context;
import android.view.View;

import java.security.PublicKey;

/**
 * Created by LiuXiaoFeng on 2016/7/13.
 * 新闻列表页底部4个tab对应pager的基类
 */
public abstract class NewsListBasePager {

    public Context context;
    public View rootView;

    NewsListBasePager(Context context,View rootView){
        this.context=context;
        this.rootView=rootView;
    }

    public abstract void initView();

    public void initData(){};
}
