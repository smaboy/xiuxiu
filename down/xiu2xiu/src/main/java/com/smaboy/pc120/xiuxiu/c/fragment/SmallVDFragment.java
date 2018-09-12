package com.smaboy.pc120.xiuxiu.c.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.activity.NewsDetailWeb;
import com.smaboy.pc120.xiuxiu.c.adapter.ListViewAdapter;
import com.smaboy.pc120.xiuxiu.c.base.BaseFragment;
import com.smaboy.pc120.xiuxiu.c.constant.NetUrl;
import com.smaboy.pc120.xiuxiu.c.event.EventMessage;
import com.smaboy.pc120.xiuxiu.c.interfaces.NetServiceInterface;
import com.smaboy.pc120.xiuxiu.c.util.AlertDialogUtils;
import com.smaboy.pc120.xiuxiu.c.util.EventBusUtils;
import com.smaboy.pc120.xiuxiu.c.util.FileUtils;
import com.smaboy.pc120.xiuxiu.m.domain.JokeEnty;
import com.smaboy.pc120.xiuxiu.m.domain.WeiXinChoiceEntity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Handler;

import cn.sharesdk.onekeyshare.themes.classic.FriendListPage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Smaboy on 2017/7/27,23:19
 * Email:405923832@qq.com
 * Better for better
 */
@SuppressLint("ValidFragment")
public class SmallVDFragment extends BaseFragment {
    private ListView listview;
    private WeiXinChoiceEntity weiXinChoiceEntity;
    private JokeEnty jokeEntity;
    private String fileInfoFromAsset;
    private SmartRefreshLayout refreshLayout;
    private int pno=1;
    private boolean selectTab1=true;

    @SuppressLint("ValidFragment")
    public SmallVDFragment(Context mContext) {
        super();
        super.mContext=mContext;
    }

    @Override
    public View setRootView(LayoutInflater inflater, ViewGroup container) {


        return inflater.inflate(R.layout.fragment_smallvd, container, false);
    }

    @Override
    public void initView() {

        listview = rootView.findViewById(R.id.listview);
        refreshLayout = rootView.findViewById(R.id.refreshLayout);

        //设置监听
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(mContext, NewsDetailWeb.class);
                intent.putExtra("url",weiXinChoiceEntity.getResult().getList().get(i).getUrl());
                intent.putExtra("title",weiXinChoiceEntity.getResult().getList().get(i).getSource());
                mContext.startActivity(intent);

            }
        });

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {

                if(selectTab1){
                    getWeiXinChoiceDataFromNet(++pno,40,"");

                } else {

                    getJokeDataFromNet();
                }

            }
        });

        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {

                if(pno<=1) {
                    AlertDialogUtils.show(mContext,"已经到底咯！要不刷新看看！！");
                    refreshLayout.finishLoadMore(2000,true,true);
                }else {
                    if(selectTab1){
                        getWeiXinChoiceDataFromNet(++pno,40,"");

                    } else {

                        getJokeDataFromNet();
                    }

                }
            }
        });

        //设置 Header 为 贝塞尔雷达 样式
        refreshLayout.setRefreshHeader(new ClassicsHeader(mContext));
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(mContext).setSpinnerStyle(SpinnerStyle.Scale));

    }


    @Override
    public void onStart() {
        super.onStart();

        EventBusUtils.register(this);
    }

    @Override
    public void initData() {


        //从网络获取数据
        getWeiXinChoiceDataFromNet(pno,20,"");

        //从本地获取数据
//        String fileInfoFromAsset = FileUtils.getFileInfoFromAsset("weixin_choice.txt", mContext);
//        weiXinChoiceEntity = new Gson().fromJson(fileInfoFromAsset, WeiXinChoiceEntity.class);
//        setData();


    }

    /**
     *
     * 从网络获取微信精选的数据
     * @param pno  当前页数，默认1
     * @param ps   每条返回数，最大50，默认20
     * @param dtype 返回的数据格式，xml或json，默认是json
     */
    private void getWeiXinChoiceDataFromNet(int pno,int ps,String dtype) {

        NetServiceInterface netServiceInterface = getNetServiceInterface(NetUrl.JH_BASEURL);
        Call<WeiXinChoiceEntity> weiXinChoice = netServiceInterface.getWeiXinChoice(pno, ps, dtype, NetUrl.JH_WEIXIN_CHOICE_APPKEY);
        weiXinChoice.enqueue(new Callback<WeiXinChoiceEntity>() {
            @Override
            public void onResponse(Call<WeiXinChoiceEntity> call, Response<WeiXinChoiceEntity> response) {
                if (response.body() != null) {//请求体不为空，则可以进行强转
                    refreshLayout.finishRefresh();//停止刷新
                    refreshLayout.finishLoadMore();//停止加载更多

                    weiXinChoiceEntity = response.body();

                    Log.e("TAG",response.code()+" ");

                    if(weiXinChoiceEntity.getResult()!=null&&weiXinChoiceEntity.getError_code()==0) {
                        //设置数据
                        EventBusUtils.post(new EventMessage(1));
                    }else {
                        AlertDialogUtils.show(mContext,weiXinChoiceEntity.getReason());
                    }




                }


            }

            @Override
            public void onFailure(Call<WeiXinChoiceEntity> call, Throwable t) {

                AlertDialogUtils.show(mContext,t.getMessage());
            }
        });
    }

    private void setData() {

        ListViewAdapter adapter=new ListViewAdapter(mContext, (ArrayList<WeiXinChoiceEntity.ResultBean.ListBean>) weiXinChoiceEntity.getResult().getList());
        listview.setAdapter(adapter);

    }

    /**
     * 看点选项卡中的笑话大全
     * http://v.juhe.cn/joke/randJoke.php?key=f95e5bf08f62e4bb4943128b63ba4042  //随机获取笑话
     *
     */
    private void getJokeDataFromNet() {
        NetServiceInterface netServiceInterface = getNetServiceInterface(NetUrl.JH_BASEURL);
        Call<JokeEnty> weiXinChoice = netServiceInterface.getJoke(NetUrl.JH_JOKE_APPKEY);
        weiXinChoice.enqueue(new Callback<JokeEnty>() {
            @Override
            public void onResponse(Call<JokeEnty> call, Response<JokeEnty> response) {
                if (response.body() != null) {//请求体不为空，则可以进行强转
                    jokeEntity = response.body();
                    //设置数据
                    EventBusUtils.post(new EventMessage(1));

                }

                if (response.body() != null) {//请求体不为空，则可以进行强转
                    refreshLayout.finishRefresh();//停止刷新
                    refreshLayout.finishLoadMore();//停止加载更多

                    jokeEntity = response.body();

                    Log.e("TAG",response.code()+" ");

                    if(jokeEntity.getResult()!=null&&jokeEntity.getError_code()==0) {
                        //设置数据
                        EventBusUtils.post(new EventMessage(1));
                    }else {
                        AlertDialogUtils.show(mContext,jokeEntity.getReason());
                    }




                }

            }

            @Override
            public void onFailure(Call<JokeEnty> call, Throwable t) {

                AlertDialogUtils.show(mContext,t.getMessage());
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        EventBusUtils.unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventMessage message){
        switch (message.getWhat()) {
            case 1 ://设置数据
                setData();
                break;

            case 100 ://主页面发过来的，选项卡选中了，微信精选
//                jokeEntity=null;
//                selectTab1=true;
//                getWeiXinChoiceDataFromNet(pno,30,"");
                break;

            case 200 ://主页面发过来的，选项卡选中了，笑话大全
//                weiXinChoiceEntity=null;
//                selectTab1=false;
//                getJokeDataFromNet();
                break;

        }
    }
}
