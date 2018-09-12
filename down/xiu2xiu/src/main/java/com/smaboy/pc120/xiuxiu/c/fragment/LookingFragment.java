package com.smaboy.pc120.xiuxiu.c.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.adapter.LookinngFragmentAdapter;
import com.smaboy.pc120.xiuxiu.c.event.EventMessage;
import com.smaboy.pc120.xiuxiu.c.fragment.looking.LookingNewsTopFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Smaboy on 2017/7/27,23:19
 * Email:405923832@qq.com
 * Better for better
 */
@SuppressLint("ValidFragment")
public class LookingFragment extends Fragment {

    protected Unbinder mUnbinder;
    @BindView(R.id.looking_tab)
    TabLayout lookingTab;
    @BindView(R.id.looking_viewpager)
    ViewPager lookingViewpager;
    private Context mContext;
    private float mPosX;
    private float mPosY;
    private float mCurPosX;
    private float mCurPosY;

    @SuppressLint("ValidFragment")
    public LookingFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_looking, container, false);

        //依赖注入
        ButterKnife.bind(this, view);

        //初始化数据
        initData();

        //设置监听
        setListener();
        return view;
    }

    private void setListener() {
        lookingViewpager.getCurrentItem();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @SuppressLint("ClickableViewAccessibility")
    private void initData() {

        //初始化数据
        String[] strs = getContext().getResources().getStringArray(R.array.looking_tabs);
        String[] types = getContext().getResources().getStringArray(R.array.looking_tabs_type);
        ArrayList<String> tabs = new ArrayList<>(Arrays.asList(strs));

        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < tabs.size(); i++) {
            fragments.add(new LookingNewsTopFragment(mContext,types[i]));

        }


        lookingViewpager.setAdapter(new LookinngFragmentAdapter(getChildFragmentManager(), fragments, tabs));

        lookingTab.setupWithViewPager(lookingViewpager);

    }



    @Override
    public void onDestroyView() {
        //butterknife 解绑
        if (this.mUnbinder != null) {
            this.mUnbinder.unbind();
        }
        super.onDestroyView();

    }



}
