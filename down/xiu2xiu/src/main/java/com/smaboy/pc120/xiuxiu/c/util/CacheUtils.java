package com.smaboy.pc120.xiuxiu.c.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 作用：缓存工具类
 */
public class CacheUtils {
    /**
     * 保持数据
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences("whoiam", Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    /**
     * 得到缓存数据
     *
     * @param context
     * @param key
     * @return
     */
    public static String getString(Context context, String key) {

        SharedPreferences sp = context.getSharedPreferences("whoiam", Context.MODE_PRIVATE);
        return sp.getString(key, "");

    }

    public static void putBoolean(Context context, String key, boolean values) {
        SharedPreferences sp = context.getSharedPreferences("whoiam", Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, values).commit();
    }

    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("whoiam", Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    public static void putInt(Context context, String key, int values) {
        SharedPreferences sp = context.getSharedPreferences("whoiam", Context.MODE_PRIVATE);
        sp.edit().putInt(key, values).commit();
    }

    public static int getInt(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("whoiam", Context.MODE_PRIVATE);
        return sp.getInt(key, -1);
    }

}
