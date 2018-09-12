package com.smaboy.pc120.xiuxiu.c.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.smaboy.pc120.xiuxiu.R;

/**
 * Created by Smaboy on 2017/12/21-22:13.
 * WHERE IS A WILL,THERE IS A WAY!
 * AlertDialog的工具类
 */

public class AlertDialogUtils {

    /**
     * 简单对话框
     *
     * @param context
     * @param bundle
     */

    public static void simpleAlertDialog(Context context, Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("简单对话框")
                .setIcon(R.drawable.cat001)
                .setMessage("测试内容")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();


    }

    /**
     * 简单列表对话框
     *
     * @param context 上下文
     * @param strs  字符串数组
     * @param itemId  数组资源的资源id
     * @param bundle  数据包
     */

    public static void simpleListAlertDialog(final Context context,String[] strs,int itemId, Bundle bundle){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("简单列表对话框")
                .setIcon(R.drawable.cat001)
                .setItems(R.array.quickSideBarLetters, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "点击了"+which, Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();


    }

    /**
     *
     * 单选列表框
     * @param  context 上下文
     * @param strs  字符串数组
     * @param itemId  数组资源的资源id
     * @param bundle  数据包
     */

    public  static  void  singleChoiceAlertDialog(final Context context,String[] strs,int itemId, Bundle bundle){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("简单列表对话框")
                .setIcon(R.drawable.cat001)
                .setSingleChoiceItems(R.array.quickSideBarLetters, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show(context,"你点击了"+which);

                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();


    }
    /**
     *
     * 单选列表框
     * @param  context 上下文
     * @param strs  字符串数组
     * @param itemId  数组资源的资源id
     * @param bundle  数据包
     */

    public  static  void  multiChoiceAlertDialog(final Context context,String[] strs,int itemId, Bundle bundle){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("简单列表对话框")
                .setIcon(R.drawable.cat001)
                .setMultiChoiceItems(strs, new boolean[strs.length], new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();


    }

    public static void show (Context context,String str){
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();

    }

}
