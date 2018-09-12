package com.smaboy.pc120.xiuxiu.c.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.adapter.TalkingFragmentAdapter;
import com.smaboy.pc120.xiuxiu.c.fragment.talking.TalkingContactFragment;
import com.smaboy.pc120.xiuxiu.c.fragment.talking.TalkingMessageFragment;
import com.smaboy.pc120.xiuxiu.c.fragment.talking.TalkingRoomFragment;

import java.util.ArrayList;

/**
 * Created by Smaboy on 2017/7/27,23:19
 * Email:405923832@qq.com
 * Better for better
 */
public class TalkingFragment extends Fragment implements View.OnClickListener {

    private ViewPager viewpager;
    private ArrayList<Fragment> fragments;
    private TabLayout tab;
    private ArrayList<String> tabs;
    private Context mContext;

    @SuppressLint("ValidFragment")
    public TalkingFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_talking, container, false);

        initView(view);

//        设置数据
        setData();

        return view;
    }


    private void setData() {


        //设置tab

        tabs=new ArrayList<>();
        tabs.add("消息");
        tabs.add("联系人");
        tabs.add("聊天室");
//        tab.setTabMode(TabLayout.MODE_FIXED);
//        tab.addTab(tab.newTab().setText(tabs.get(0)));
//        tab.addTab(tab.newTab().setText(tabs.get(1)));
//        tab.addTab(tab.newTab().setText(tabs.get(2)));




        fragments=new ArrayList<>();
        fragments.add(new TalkingMessageFragment());
        fragments.add(new TalkingContactFragment());
        fragments.add(new TalkingRoomFragment());




        viewpager.setAdapter(new TalkingFragmentAdapter(getChildFragmentManager(),fragments,tabs));


        tab.setupWithViewPager(viewpager);


    }


    private void initView(View view) {

        tab=(TabLayout)view.findViewById(R.id.tab);

//        fl = (ContentFrameLayout) view.findViewById(R.id.tf_fl);

        viewpager=(ViewPager)view.findViewById(R.id.tf_viewpager);




    }






    @Override
    public void onClick(View v) {



    }

    public static void setSnackbarColor(Snackbar snackbar, int messageColor, int backgroundColor) {
        View view = snackbar.getView();//获取Snackbar的view
        if(view!=null){
            view.setBackgroundColor(backgroundColor);//修改view的背景色
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(messageColor);//获取Snackbar的message控件，修改字体颜色
        }
    }

}
