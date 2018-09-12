package com.smaboy.pc120.xiuxiu.c.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gm11 on 2016/9/12.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    //数据库文件名
    private final static String DB_NAME = "my_database.db";
    //数据库版本号
    private final static int DB_VERSION = 1;
    //数据库表名
    public final static String TABLE_INFORM = "table_inform";

    public DataBaseHelper(Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists " + TABLE_INFORM + "(_id integer primary key autoincrement, content varchar, kind varchar,type varchar,state integer,detail varchar)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
