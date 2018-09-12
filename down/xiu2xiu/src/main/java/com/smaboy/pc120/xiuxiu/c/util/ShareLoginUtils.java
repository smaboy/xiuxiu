package com.smaboy.pc120.xiuxiu.c.util;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.m.domain.XXUser;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

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
    private static void loginByOthers( Platform otherLogin) {


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



    /**
     * 登录环信服务器
     *
     * @param userId
     * @param password
     */
    public static void loginHX(String userId, String password , final Context context) {
        //登录环信服务器
        EMClient.getInstance().login(userId,password,new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                Log.d("main", "登录聊天服务器成功！");
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                if(code==204) {//用户不存在
                    //使用第三方登录或前往注册页面
                    Toast.makeText(context, "用户不存在", Toast.LENGTH_SHORT).show();
                }
                if(code==202) {//用户id或密码错误
                    Toast.makeText(context, "用户id或密码错误", Toast.LENGTH_SHORT).show();
                }
                
            }
        });
    }


    /**
     * 注册环信服务器
     * @param userId
     * @param password
     * @return 错误码,0 表示无错误，注册成功
     */
    public static int registerHX(String userId, String password) {
        //注册失败会抛出HyphenateException
        try {
            EMClient.getInstance().createAccount(userId, userId);//同步方法
        } catch (HyphenateException e) {
            e.printStackTrace();
            LogUtil.e(e.toString());

            return e.getErrorCode();
        }

        return 0;
    }


}
