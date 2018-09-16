package com.smaboy.pc120.xiuxiu;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.mob.MobSDK;
import com.smaboy.pc120.xiuxiu.c.util.LogUtil;

/**
 * Created by Smoboy on 2017/7/27.
 */

public class MyApplication extends MultiDexApplication {

    public Context mContext;

    @Override
    public void onCreate() {


        mContext = getBaseContext();

        //配置日志
        LogUtil.allowE = false;
        LogUtil.customTagPrefix = "TAG";

        //初始化Mob平台sdk
        MobSDK.init(mContext);

        super.onCreate();
    }

    @Override
    public Context getBaseContext() {
        return super.getBaseContext();
    }


}
