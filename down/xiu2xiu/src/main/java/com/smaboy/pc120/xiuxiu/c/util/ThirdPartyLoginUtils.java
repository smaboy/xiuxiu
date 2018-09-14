package com.smaboy.pc120.xiuxiu.c.util;

import com.smaboy.pc120.xiuxiu.m.domain.XXUser;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;

/**
 * 类名: ThirdPartyLoginUtils
 * 类作用描述: 第三方登录工具类
 * 作者: Smaboy
 * 创建时间: 2018/9/14 18:04
 */
public class ThirdPartyLoginUtils {

    /**
     * 判断是否授权 是的话获取授权信息，不是的话申请授权
     *
     * @param name 授权的第三方应用名称
     */
    public static void applyPlatform(String name) {

        Platform platform = ShareSDK.getPlatform(name);
        if (platform.isAuthValid()) {//已经授权，获取授权信息

//            platform.removeAccount(true);

            parsePlatformMsg(platform);

        } else {

            //没有授权，准备申请授权
            startApplyPlatform(platform);

        }


    }

    /**
     * 第三方
     * 登录信息处理
     *
     * @param platform
     */
    private static void parsePlatformMsg(Platform platform) {
        String userId = "";
        String pwd = "";
        String userNick = "";
        String userIcon = "";

        LogUtil.e( "开始解析获取到的用户信息");


        userId = platform.getDb().get("userID");
        pwd = platform.getDb().get("userID");
        userNick = platform.getDb().get("nickname");
        userIcon = platform.getDb().get("icon");

        LogUtil.e( userId + "--" + pwd + "---" + userNick + "---" + userIcon);


        //将数据传入注册
        XXUser xxUser = new XXUser(userId, pwd, userIcon, userNick);


        //开始注册环信服务器
        registerHX(xxUser);


    }

    /**
     * 这个方法是正在的注册（该用户名存在，就直接用该用户名登录）
     * 在这里，我们规定注册侧逻辑
     *
     *
     * @param xxUser
     */
    private static void registerHX(final XXUser xxUser) {
        //注册失败会抛出HyphenateException
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    LogUtil.e("第三方登录时用户id:"+xxUser.getUserId()+"/n"+"转为小写:"+xxUser.getUserId().toLowerCase());
//                    EMClient.getInstance().createAccount(xxUser.getUserId(), xxUser.getUserPwd());//同步方法
//                } catch (HyphenateException e) {
//                    e.printStackTrace();
//                    LogUtil.e("注册失败");
//                }
//            }
//        }).start();


    }

    /**
     * 第三方登录授权
     *
     * @param platform
     */
    private static void startApplyPlatform(Platform platform) {


        platform.SSOSetting(false);  //设置false表示使用SSO授权方式,有客户端优先调用
        platform.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                LogUtil.e("授权成功："+platform.toString());
                parsePlatformMsg(platform);


            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                LogUtil.e("授权失败："+platform.toString());
            }

            @Override
            public void onCancel(Platform platform, int i) {
                LogUtil.e("授权被取消："+platform.toString());

            }
        });
//authorize与showUser单独调用一个即可
//        platform.authorize();//单独授权,OnComplete返回的hashmap是空的
        platform.showUser(null);//授权并获取用户信息

////        //获取用户信息
//        //获取用户信息
//        platform.getDb().getPlatformNname();
//        platform.getDb().getToken(); // 获取授权token
//        platform.getDb().getUserId(); // 获取用户在此平台的ID
//        platform.getDb().getUserIcon();//获取用户头像
//        platform.getDb().getUserName(); // 获取用户昵称



    }

}
