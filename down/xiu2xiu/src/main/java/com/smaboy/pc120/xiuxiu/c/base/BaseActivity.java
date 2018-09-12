package com.smaboy.pc120.xiuxiu.c.base;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.util.UIUtils;

/**
 * Created by Smoboy on 2017/4/21.
 */

public class BaseActivity extends Activity {



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("BaseActivity", getClass().getSimpleName());


//        沉浸式菜单栏
        UIUtils.setImmersiveMenuBar(this);


        setContentView(R.layout.activity_base);



    }



}
