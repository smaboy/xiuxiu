package com.smaboy.pc120.xiuxiu.c.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 类名: SPUtils
 * 类作用描述: java类作用描述
 * 作者: Smaboy
 * 创建时间: 2018/9/14 16:33
 */
public class SPUtils {
    public static final String mTAG = "test";
//    创建一个写入器
    private static SharedPreferences mPreferences;
    private static SharedPreferences.Editor mEditor;
    private static SPUtils mSPUtils;

//    构造方法
    public SPUtils(Context context) {
        mPreferences =   context.getSharedPreferences(mTAG,Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
    }

//    单例模式
    public static SPUtils getInstance(Context context) {
        if (mSPUtils ==null){
            synchronized (SPUtils.class){

                mSPUtils =new SPUtils(context);
            }
        }
        return  mSPUtils;
    }

//    存入数据
    public void putSP(String key,String value) {
        mEditor.putString(key,value);
        mEditor.commit();
    }

//    获取数据
    public String getSP(String key) {
        return mPreferences.getString(key,"");
    }

//    移除数据
    public void removeSP(String key) {
        mEditor.remove(key);
        mEditor.commit();
    }

}
