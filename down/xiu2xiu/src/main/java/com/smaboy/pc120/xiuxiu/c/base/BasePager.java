package com.smaboy.pc120.xiuxiu.c.base;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
* Created by Smaboy on 2017/8/14,23:06
* Email:405923832@qq.com
* Better for better
 *
 * 该页面作为Talki难过的viewpager的view的基类
 *
*/




public class BasePager {

    private Context mContext;
    private View rootView;

    public void BasePager(Context context){
        this.mContext=context;
        initView();

    }

    //初始化视图
    private void initView() {

        Canvas can=new Canvas();


    }


    //初始化数据
    private void initData(){


    }

}
