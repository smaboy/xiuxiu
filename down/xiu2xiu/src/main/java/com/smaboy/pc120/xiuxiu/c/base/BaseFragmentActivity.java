package com.smaboy.pc120.xiuxiu.c.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.manager.ActivityTaskManager;
import com.smaboy.pc120.xiuxiu.c.util.UIUtils;

/**
 * Created by Smaboy on 2017/12/20-17:19.
 * WHERE IS A WILL,THERE IS A WAY!
 */

public class BaseFragmentActivity extends FragmentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置沉浸式菜单栏
        UIUtils.setImmersiveMenuBar(this);

        //将activity添加到activity管理器中
        ActivityTaskManager.getInstance().addActivity(this.getLocalClassName(),this);

//        setContentView(R.layout.activity_base);
    }


}
