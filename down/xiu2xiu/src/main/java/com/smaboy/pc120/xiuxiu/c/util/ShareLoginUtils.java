package com.smaboy.pc120.xiuxiu.c.util;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.smaboy.pc120.xiuxiu.R;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by Smaboy on 2017/12/11-21:47.
 * WHERE IS A WILL,THERE IS A WA!
 */

public class ShareLoginUtils {


    public static void showShare(Context context, Bundle bundle) {
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("良子发来的分享");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("https://user.qzone.qq.com/405923832/infocenter");
// text是分享文本，所有平台都需要这个字段
        oks.setText("612的同志们");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("https://user.qzone.qq.com/405923832/infocenter");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(context.getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("https://user.qzone.qq.com/405923832/infocenter");

// 启动分享GUI
        oks.show(context);
    }

    /**
     * 判断是否授权 是的话移除授权
     * 否则直接进行授权
     *
     * @param name 授权的第三方应用名称
     */
    public static void getPlatform(String name) {

        Platform otherLogin = ShareSDK.getPlatform(name);
        if (otherLogin.isAuthValid()) {
            otherLogin.removeAccount(true);
        }
        loginByOthers(otherLogin);


    }

    /**
     * 第三方登录授权
     *
     * @param otherLogin
     */
    private static void loginByOthers(Platform otherLogin) {


        otherLogin.SSOSetting(false);  //设置false表示使用SSO授权方式,有客户端优先调用
        otherLogin.setPlatformActionListener(new PlatformActionListener() {//otherLogin.setPlatformActionListener(this); // 设置分享事件回调

            @Override
            public void onError(Platform arg0, int arg1, Throwable arg2) {
                // TODO Auto-generated method stub
                arg2.printStackTrace();
            }

            @Override
            public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                // TODO Auto-generated method stub
                //输出所有授权信息
//                arg0.getDb().exportData();
                //导入所有授权信息
                arg0.getDb().importData(arg2.toString());
                Log.e("tag", "------------" + arg2.toString());


            }

            @Override
            public void onCancel(Platform arg0, int arg1) {
                // TODO Auto-generated method stub

            }
        });
//authorize与showUser单独调用一个即可
//        otherLogin.authorize();//单独授权,OnComplete返回的hashmap是空的
        otherLogin.showUser(null);//授权并获取用户信息

//        //获取用户信息
//        getUserInfo(name, otherLogin);


// 接下来执行您要的操作


    }


}
