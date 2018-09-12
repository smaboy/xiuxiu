package com.smaboy.pc120.xiuxiu.c.base;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smaboy.pc120.xiuxiu.c.interfaces.NetServiceInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Smaboy on 2018/3/5-21:09.
 * WHERE IS A WILL,THERE IS A WAY!
 *
 * 主页所有fraqgment的基类
 */

public abstract class BaseFragment extends Fragment {


    public View rootView;

    public String type;
    public Context mContext;
    public String reason;
    public int error_code;
    public String file_str;

    private Handler handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message message) {

            switch (message.what) {
                case 0:





                    break;
                case 1:



                    break;

                case 2://



                    break;

                case 3://解析


                    break;
            }
            return false;
        }
    });



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //初始化布局
        rootView=setRootView(inflater,container);


        //初始化控件
        initView();

        //初始化数据
        initData();


        return rootView;
    }



    public abstract View setRootView(LayoutInflater inflater, ViewGroup container);//设置布局
    public abstract void initView();//初始化布局控件
    public abstract void initData();//初始化数据


    /**
     *
     * 获取网络服务管理接口的实现
     * @param baseUrl 基类url
     * @return
     */
    public NetServiceInterface getNetServiceInterface(String baseUrl ) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 支持RxJava平台
                .build();

        NetServiceInterface netServiceInterface = retrofit.create(NetServiceInterface.class);

       return netServiceInterface;
    }

    /**
     * 从assets中获取，文件内容
     *
     * @param fileName
     */
    private void getFileInfoFromAssets(final String fileName) {
        //开启一个子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AssetManager manager =getResources().getAssets();
                    InputStream inputStream = manager.open(fileName);
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

                    file_str=sb.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
