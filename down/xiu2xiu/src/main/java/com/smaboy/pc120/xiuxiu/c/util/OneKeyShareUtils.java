package com.smaboy.pc120.xiuxiu.c.util;

import android.content.Context;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * 类名: OneKeyShareUtils
 * 类作用描述: 一键分享工具类
 * 作者: Smaboy
 * 创建时间: 2018/9/18 9:38
 */
public class OneKeyShareUtils {


    /**
     *
     * @param title title标题，微信、QQ和QQ空间等平台使用
     * @param titleUrl titleUrl QQ和QQ空间跳转链接
     * @param text text是分享文本，所有平台都需要这个字段
     * @param imagePath imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
     * @param url url在微信、微博，Facebook等平台中使用
     * @param comment comment是我对这条分享的评论，仅在人人网使用
     * @param context 上下文
     */
    public static void showShare(String title, String titleUrl, String text, String imagePath, String url,String comment, Context context) {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle(title);
        // titleUrl QQ和QQ空间跳转链接
        oks.setTitleUrl(titleUrl);
        // text是分享文本，所有平台都需要这个字段
        oks.setText(text);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath(imagePath);//确保SDcard下面存在此张图片
        // url在微信、微博，Facebook等平台中使用
        oks.setUrl(url);
        // comment是我对这条分享的评论，仅在人人网使用
        oks.setComment(comment);
        // 启动分享GUI
        oks.show(context);
    }
}
