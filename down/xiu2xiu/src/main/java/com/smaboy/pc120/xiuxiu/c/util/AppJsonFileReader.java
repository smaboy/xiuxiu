package com.smaboy.pc120.xiuxiu.c.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gm11 on 2016/7/12.
 */
public class AppJsonFileReader {
    public static String getJson(Context context,String fileName){
        StringBuilder stringBuilder = new StringBuilder();
        AssetManager assetManager = context.getAssets();
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine())!= null){
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    public static String getJsonFromSD(Context context,String fileName){
        StringBuilder stringBuilder = new StringBuilder();
        AssetManager assetManager = context.getAssets();
        try {
            if(fileName==null) {
                return "";
            }
            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String line;
            while ((line = bf.readLine())!= null){
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("-------", "查询SD卡文件" );
        return stringBuilder.toString();
    }
    public static Map setData(String string){
        Map map = new HashMap();
        ArrayList<String> list_01 = new ArrayList<>();
        ArrayList<ArrayList<String>> list_02 = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<String>>> list_03 = new ArrayList<>();


        ArrayList<ArrayList<ArrayList<String[]>>> list_03_end = new ArrayList<>();
//        ArrayList<Map<String,String>> list_03_03 = new ArrayList<>();
        try {
//            JSONObject jsonObject = new JSONObject(string);
//            JSONArray array_01 = jsonObject.getJSONArray("data");
            JSONArray array_01 = new JSONArray(string);
            //第一级
            for (int i = 0;i<array_01.length();i++){
                JSONObject object_01 = array_01.getJSONObject(i);
                list_01.add(object_01.getString("regionName"));

                //第二级
                JSONArray array_02 = object_01.getJSONArray("child");

                ArrayList<String> list_02_list = new ArrayList<>();
                ArrayList<ArrayList<String>> list_03_list = new ArrayList<>();


                ArrayList<ArrayList<String[]>> list_03_list_end = new ArrayList<>();

                for (int j = 0;j<array_02.length();j++){
                    JSONObject object_02 = array_02.getJSONObject(j);
                    list_02_list.add(object_02.getString("regionName"));

                    //第三极
                    JSONArray array_03 = object_02.getJSONArray("child");

                    ArrayList<String> list_03_list_ = new ArrayList<>();

                    ArrayList<String[]> list_03_array_end = new ArrayList<>();

                    for (int k = 0;k<array_03.length();k++){
                        JSONObject object_03 = array_03.getJSONObject(k);

                        String[] reginoArray = new String[2];
                        reginoArray[0] = object_03.getString("regionName");
                        reginoArray[1] = object_03.getString("regionId");
                        list_03_array_end.add(reginoArray);

                        list_03_list_.add(object_03.getString("regionName"));
                    }
                    list_03_list.add(list_03_list_);
                    list_03_list_end.add(list_03_array_end);
                }
                list_03.add(list_03_list);
                list_02.add(list_02_list);
                list_03_end.add(list_03_list_end);
            }
            map.put(1,list_01);
            map.put(2,list_02);
            map.put(3,list_03);
            map.put(4,list_03_end);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map;
    }
    public static List<Map> setListData(String string){
        List<Map> data= new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(string);
            JSONArray arrayFirst = jsonObject.getJSONArray("data");
            int len = arrayFirst.length();
            Map mapFirst ;
            for (int i = 0;i<len;i++){
                JSONObject objectFirst = arrayFirst.getJSONObject(i);
                mapFirst = new HashMap();
                mapFirst.put("reginoName",objectFirst.getString("reginoName"));
                JSONArray arraySecond = objectFirst.getJSONArray("child");
                List<Map> dataSecond = new ArrayList<>();
                int lenSecond = arraySecond.length();
                Map mapSecond;
                for (int j = 0;j<lenSecond;j++){
                    JSONObject objectSecond = arraySecond.getJSONObject(j);
                    mapSecond = new HashMap();
                    mapSecond.put("reginoName",objectSecond.getString("reginoName"));
                    JSONArray arrayThrid = objectSecond.getJSONArray("child");
                    List<String> dataThird = new ArrayList<>();
                    int lenThird = arrayThrid.length();
                    for (int k = 0;k <lenThird;k++){
                        JSONObject objectThrid = arrayThrid.getJSONObject(k);
                        dataThird.add(objectThrid.getString("reginoName"));
                    }
                    mapSecond.put("child",dataThird);
                    dataSecond.add(mapSecond);
                }
                mapFirst.put("child",dataSecond);
                data.add(mapFirst);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
}
