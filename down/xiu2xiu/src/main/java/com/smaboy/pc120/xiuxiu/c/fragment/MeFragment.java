package com.smaboy.pc120.xiuxiu.c.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.base.BaseFragment;
import com.smaboy.pc120.xiuxiu.c.util.LogUtil;

/**
* Created by Smaboy on 2017/7/27,23:19
* Email:405923832@qq.com
* Better for better
*/
public class MeFragment extends BaseFragment {


    @Override
    public View setRootView(LayoutInflater inflater, ViewGroup container) {
        LogUtil.e("我被创建了");
        return inflater.inflate(R.layout.fragment_me,container,false);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
