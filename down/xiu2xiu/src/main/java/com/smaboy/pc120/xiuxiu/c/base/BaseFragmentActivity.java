package com.smaboy.pc120.xiuxiu.c.base;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;

import com.smaboy.pc120.xiuxiu.c.util.UIUtils;

/**
 * Created by Smaboy on 2017/12/20-17:19.
 * WHERE IS A WILL,THERE IS A WAY!
 */

public class BaseFragmentActivity extends FragmentActivity {

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        UIUtils.setImmersiveMenuBar(this);


        return super.onCreateView(name, context, attrs);


    }



}
