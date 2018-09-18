package com.smaboy.pc120.xiuxiu.c.util;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

/**
 * 类名: ThirdPartLoginUtils
 * 类作用描述: 第三方登录工具类
 * 作者: Smaboy
 * 创建时间: 2018/9/18 9:47
 */
public class ThirdPartLoginUtils  {

    /**
     *
     * 获取授权信息
     * @param name 第三方登录平台名称，eg：QQ.NAME
     * @param removeCookie 移除授权状态和本地缓存，下次授权会重新授权
     * @param disable SSO授权，传false默认是客户端授权，没有客户端授权或者不支持客户端授权会跳web授权
     * @param platformActionListener 授权回调监听，监听oncomplete，onerror，oncancel三种状态
     */
    public static void getPlatform(String name, boolean removeCookie, boolean disable, PlatformActionListener platformActionListener) {
        Platform plat = ShareSDK.getPlatform(name);
        plat.removeAccount(removeCookie); //移除授权状态和本地缓存，下次授权会重新授权
        plat.SSOSetting(disable); //SSO授权，传false默认是客户端授权，没有客户端授权或者不支持客户端授权会跳web授权
        plat.setPlatformActionListener(platformActionListener);//授权回调监听，监听oncomplete，onerror，oncancel三种状态
        if (plat.isClientValid()) {
            //判断是否存在授权凭条的客户端，true是有客户端，false是无
        }
        if (plat.isAuthValid()) {
            //判断是否已经存在授权状态，可以根据自己的登录逻辑设置
//            Toast.makeText(this, "已经授权过了", 0).show();
            return;
        }
        //plat.authorize();	//要功能，不要数据，如果你的应用不具备用户系统
        plat.showUser(null);    //要数据不要功能，主要体现在不会重复出现授权界面，如果你的应用拥有用户系统
    }
}
