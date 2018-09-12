package com.smaboy.pc120.xiuxiu.c.adapter;

import android.view.View;

import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.AuthorizeAdapter;

/**
 * Created by Smaboy on 2017/12/21-13:14.
 * WHERE IS A WILL,THERE IS A WAY!
 *
 * 定制web授權頁面的標題欄的UI的
 */

public class MyPlatformAdapter extends AuthorizeAdapter {

    public void onCreate() {

        //隱藏sharesdk右邊的logo
        hideShareSDKLogo();
//获取标题栏控件
//        TitleLayout llTitle = getTitleLayout();
//标题栏的文字修改
//        int resID= R.getStringRes(getActivity(), "second_title");//这个字段定义在strings.xml文件里面
//        llTitle.getTvTitle().setText("良子");
//        llTitle.getBtnRight().setVisibility(View.GONE);
    }

    public void onDestroy() {
        System.out.println("> ShareSDKUIShell will be destroyed.");
    }
}
