package com.smaboy.pc120.xiuxiu.c.util;

import android.content.Context;
import android.content.res.AssetManager;

import com.smaboy.pc120.xiuxiu.MyApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 文件获取和存储帮助类
 *
 *
 */

public class FileUtils {


    /**
     * 获取assets中文件的内容，并以字符串的形式返回
     *
     * @param filename 文件名称(须加文件后缀名)
     * @return 字符集
     */
    public static String getFileInfoFromAsset(String filename ,Context context){
        AssetManager manager = context.getResources().getAssets();
        try {
            InputStream inputStream = manager.open(filename);
            InputStreamReader isr = new InputStreamReader(inputStream,
                    "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String length;
            while ((length = br.readLine()) != null) {
                sb.append(length);
            }
            //关流
            br.close();
            isr.close();
            inputStream.close();

            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";


    }

}
