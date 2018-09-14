package com.smaboy.pc120.xiuxiu;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.support.multidex.MultiDexApplication;

import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;
import com.mob.MobSDK;
import com.smaboy.pc120.xiuxiu.c.util.LogUtil;

/**
 * Created by Smoboy on 2017/7/27.
 */

public class MyApplication extends MultiDexApplication {

    public  Context mContext;

    @Override
    public void onCreate() {


        mContext = getBaseContext();


//        初始化环信
        EMOptions options = new EMOptions();
        // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
// 是否自动将消息附件上传到环信服务器，默认为True是使用环信服务器上传下载，如果设为 false，需要开发者自己处理附件消息的上传和下载
        options.setAutoTransferMessageAttachments(true);
// 是否自动下载附件类消息的缩略图等，默认为 true 这里和上边这个参数相关联
        options.setAutoDownloadThumbnail(true);
        EaseUI.getInstance().init(mContext, options);

//        初始化shareSDK
//如配置文件中已有appkey和scret就不需要在这填了，只需填写上下文
//        如果选择通过代码配置，则不需要继承MobApplication，只要在使用ShareSDK之前，调用以下代码：
// 通过代码注册你的AppKey和AppSecretMobSDK.init(context, "你的AppKey", "你的AppSecret");
        MobSDK.init(mContext);

        //解决7.0调用相机崩溃
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder build = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(build.build());
        }


        //配置日志
        LogUtil.allowE=true;
        LogUtil.customTagPrefix="TAG";

        super.onCreate();
    }

    @Override
    public Context getBaseContext() {
        return super.getBaseContext();
    }


}
