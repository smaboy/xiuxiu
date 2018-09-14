package com.smaboy.pc120.xiuxiu;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
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


//        初始化环信
//        EMOptions options = new EMOptions();
//        // 默认添加好友时，是不需要验证的，改成需要验证
//        options.setAcceptInvitationAlways(false);
//// 是否自动将消息附件上传到环信服务器，默认为True是使用环信服务器上传下载，如果设为 false，需要开发者自己处理附件消息的上传和下载
//        options.setAutoTransferMessageAttachments(true);
//// 是否自动下载附件类消息的缩略图等，默认为 true 这里和上边这个参数相关联
//        options.setAutoDownloadThumbnail(true);
//        EaseUI.getInstance().init(mContext, options);

//        初始化shareSDK
        MobSDK.init(mContext);

        //配置日志
        LogUtil.allowE = false;
        LogUtil.customTagPrefix = "TAG";

        super.onCreate();
    }

    @Override
    public Context getBaseContext() {
        return super.getBaseContext();
    }


}
