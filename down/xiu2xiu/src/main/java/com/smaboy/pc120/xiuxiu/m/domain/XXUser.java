package com.smaboy.pc120.xiuxiu.m.domain;

import org.greenrobot.greendao.annotation.Property;

/**
 * Created by Smaboy on 2017/12/20-16:44.
 * WHERE IS A WILL,THERE IS A WAY!
 *
 * 咻咻用户封装类
 */

public class XXUser {
    private String userId;
    private String userPwd;
    private String userIcon;
    private String userNick;

    public XXUser() {
    }

    public XXUser(String userId, String userPwd, String userIcon, String userNick) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userIcon = userIcon;
        this.userNick = userNick;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }



    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    @Override
    public String toString() {
        return "XXUser{" +
                "userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userIcon='" + userIcon + '\'' +
                ", userNick='" + userNick + '\'' +
                '}';
    }
}
