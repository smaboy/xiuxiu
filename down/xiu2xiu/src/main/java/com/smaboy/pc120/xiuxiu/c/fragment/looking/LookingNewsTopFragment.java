package com.smaboy.pc120.xiuxiu.c.fragment.looking;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.adapter.LookingNewsTopFragmentAdapter;
import com.smaboy.pc120.xiuxiu.c.constant.NetUrl;
import com.smaboy.pc120.xiuxiu.c.interfaces.NetServiceInterface;
import com.smaboy.pc120.xiuxiu.m.domain.NewsTopEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Smaboy on 2018/3/26-20:19.
 * WHERE IS A WILL,THERE IS A WAY!
 */

@SuppressLint("ValidFragment")
public class LookingNewsTopFragment extends Fragment {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.ll_progress)
    LinearLayout llProgress;
    Unbinder unbinder;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;

    private ArrayList<NewsTopEntity.ResultBean.DataBean> data;

    private String type;
    private Context mContext;
    private String reason;
    private int error_code;

    private Handler handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message message) {

            switch (message.what) {
                case 0:


                    llProgress.setVisibility(View.GONE);
                    Toast.makeText(getContext(), reason, Toast.LENGTH_SHORT).show();

                    //开始处理数据
                    if (data != null && data.size() > 0) {
                        //设置布局管理器
                        recycler.setLayoutManager(new LinearLayoutManager(mContext));
//                        recycler.setLayoutManager(new GridLayoutManager(this, 2));//这里用线性宫格显示 类似于grid view
//                        recycler.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));//这里用线性宫格显示 类似于瀑布流
                        //设置adapter
                        recycler.setAdapter(new LookingNewsTopFragmentAdapter(data, mContext));
                        //设置Item增加、移除动画
                        recycler.setItemAnimator(new DefaultItemAnimator());
//                        //添加分割线
//                        recycler.addItemDecoration(new DividerItemDecoration(
//                                mContext, DividerItemDecoration.HORIZONTAL));

                        refreshLayout.finishRefresh(true);

                    }

                    break;
                case 1:

                    llProgress.setVisibility(View.GONE);
                    Toast.makeText(getContext(), "网络好像出问题了,正在载入本地缓存...", Toast.LENGTH_SHORT).show();
                    getNewsFromLocal();

                    break;

                case 2://

                    Toast.makeText(getContext(), reason, Toast.LENGTH_SHORT).show();
                    getNewsFromLocal();


                    break;

                case 3://解析
                    parseData();

                    break;
            }
            return false;
        }
    });
    private String json;
    private NewsTopEntity newsTopEntity;


    @SuppressLint("ValidFragment")
    public LookingNewsTopFragment(Context mContext, String type) {
        this.type = type;
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_talking_room, container, false);

        unbinder = ButterKnife.bind(this, view);

        initEvent();

        //初始化数据
        initData();

        return view;
    }

    private void initEvent() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {

                getNewsFromNet(type);

            }
        });

        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {

                refreshLayout.finishLoadMore(2000);
            }
        });

        //设置 Header 为 贝塞尔雷达 样式
        refreshLayout.setRefreshHeader(new ClassicsHeader(mContext));
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(mContext).setSpinnerStyle(SpinnerStyle.Scale));

    }

    private void initData() {
        //从网络获取
        getNewsFromNet(type);

        //从本地获取
//        getNewsFromLocal();

    }

    /**
     * 从本地获取数据
     */
    private void getNewsFromLocal() {
        getFileInfoFromAssets("news_top");


    }

    private void getFileInfoFromAssets(final String fileName) {
        //开启一个子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AssetManager manager = getResources().getAssets();
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

                    json = sb.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(3);
            }
        }).start();
    }

    private void parseData() {
        if (TextUtils.isEmpty(json))
            return;
        Gson gson = new Gson();
        NewsTopEntity newsTopEntity = gson.fromJson(json, NewsTopEntity.class);
        if (newsTopEntity != null && newsTopEntity.getResult() != null && newsTopEntity.getResult().getData() != null) {
            data = (ArrayList<NewsTopEntity.ResultBean.DataBean>) newsTopEntity.getResult().getData();
            handler.sendEmptyMessage(0);
            refreshLayout.finishRefresh(false);
        }
    }


    //新闻头条请求工具
    public void getNewsFromNet(String type) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetUrl.JH_BASEURL)
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 支持RxJava平台
                .build();

        NetServiceInterface newsTouTiaoInterface = retrofit.create(NetServiceInterface.class);

//        Call<NewsTopEntity> call = newsTouTiaoInterface.getTop("top",NetServiceInterface.JH_APPKEY);
        Call<NewsTopEntity> call = newsTouTiaoInterface.getNewsByType(type, NetUrl.JH_NEWS_APPKEY);
// 用法和OkHttp的call如出一辙,
// 不同的是如果是Android系统回调方法执行在主线程

        //显示加载框
//        llProgress.setVisibility(View.VISIBLE);

        //开始请求
        call.enqueue(new Callback<NewsTopEntity>() {


            @Override
            public void onResponse(Call<NewsTopEntity> call, Response<NewsTopEntity> response) {

                Log.e("_newsbody", response.body() == null ? "null" : response.body().toString());
                Log.e("_newsbody", call.toString());


//                1.初始设计
                reason = response.body().getReason();
                error_code = response.body().getError_code();



                //做个处理判断是否正确解析出来了
                if (error_code == 0) {

                    data = (ArrayList<NewsTopEntity.ResultBean.DataBean>) response.body().getResult().getData();
                    handler.sendEmptyMessage(0);
                }else {
                    handler.sendEmptyMessage(2);
                    refreshLayout.finishRefresh(false);

                }



            }

            @Override
            public void onFailure(Call<NewsTopEntity> call, Throwable t) {

                handler.sendEmptyMessage(1);


            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
