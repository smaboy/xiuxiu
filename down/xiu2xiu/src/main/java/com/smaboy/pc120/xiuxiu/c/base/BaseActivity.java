package com.smaboy.pc120.xiuxiu.c.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.manager.ActivityTaskManager;
import com.smaboy.pc120.xiuxiu.c.util.EventBusUtils;
import com.smaboy.pc120.xiuxiu.c.util.UIUtils;

/**
 * Created by Smaboy on 2017/12/20-17:19.
 * WHERE IS A WILL,THERE IS A WAY!
 */

public class BaseActivity extends FragmentActivity {

    public Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置沉浸式菜单栏
        UIUtils.setImmersiveMenuBar(this);

        //将activity添加到activity管理器中
        ActivityTaskManager.getInstance().addActivity(getClass().getSimpleName(), this);


        //上下文
        context=this;

        //设置空的view
        setContentView(R.layout.activity_base);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //将activity移除activity管理器
        ActivityTaskManager.getInstance().removeActivity(getClass().getSimpleName());

    }

}
