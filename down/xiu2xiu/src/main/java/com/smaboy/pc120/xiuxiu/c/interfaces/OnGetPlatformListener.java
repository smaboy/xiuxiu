package com.smaboy.pc120.xiuxiu.c.interfaces;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;

/**
 * Created by Smaboy on 2017/12/21-9:45.
 * WHERE IS A WILL,THERE IS A WAY!
 *
 * 监听授权获取情况
 */

public interface OnGetPlatformListener {

    void getSuccess(Platform arg0, int arg1, HashMap<String, Object> arg2);

    void getFailture(Platform arg0, int arg1, Throwable arg2);

    void cancel(Platform arg0, int arg1);
}
