package com.smaboy.pc120.xiuxiu.c.event;

import android.os.Bundle;

/**
 * Created by Smaboy on 2018/7/13-16:11.
 * WHERE IS A WILL,THERE IS A WAY!
 */
public class EventMessage {
    public static final String NEWS_DETAILS_WEB="0x100001";

    private int what;
    private String message;
    private String[] org;
    private Object obj;
    private Bundle bundle;

    public EventMessage(int what) {
        this.what = what;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }



    public EventMessage() {
    }

    public int getWhat() {
        return what;
    }

    public void setWhat(int what) {
        this.what = what;
    }

    public String[] getOrg() {
        return org;
    }

    public void setOrg(String[] org) {
        this.org = org;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
