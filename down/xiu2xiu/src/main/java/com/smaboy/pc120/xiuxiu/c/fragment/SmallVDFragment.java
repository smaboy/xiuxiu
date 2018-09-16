package com.smaboy.pc120.xiuxiu.c.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.activity.NewsDetailWeb;
import com.smaboy.pc120.xiuxiu.c.base.BaseFragment;
import com.smaboy.pc120.xiuxiu.c.constant.NetUrl;
import com.smaboy.pc120.xiuxiu.c.event.EventMessage;
import com.smaboy.pc120.xiuxiu.c.interfaces.NetServiceInterface;
import com.smaboy.pc120.xiuxiu.c.util.AlertDialogUtils;
import com.smaboy.pc120.xiuxiu.c.util.EventBusUtils;
import com.smaboy.pc120.xiuxiu.m.domain.JokeEnty;
import com.smaboy.pc120.xiuxiu.m.domain.WeiXinChoiceEntity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Smaboy on 2017/7/27,23:19
 * Email:405923832@qq.com
 * Better for better
 */
public class SmallVDFragment extends BaseFragment {

    @Override
    public View setRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_me,container,false);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
