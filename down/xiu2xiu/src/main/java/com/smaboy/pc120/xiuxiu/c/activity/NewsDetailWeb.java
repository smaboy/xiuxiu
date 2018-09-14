package com.smaboy.pc120.xiuxiu.c.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.base.BaseFragmentActivity;
import com.smaboy.pc120.xiuxiu.c.util.UIUtils;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.carbs.android.avatarimageview.library.AvatarImageView;

/**
 * Created by Smaboy on 2018/7/13-16:19.
 * WHERE IS A WILL,THERE IS A WAY!
 */
@SuppressLint("Registered")
public class NewsDetailWeb extends BaseFragmentActivity {

    @BindView(R.id.user_head)
    AvatarImageView userHead;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.ll_mul_choice)
    LinearLayout ll_mul_choice;

    private Unbinder bind;

    private String title;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news_detail_web);
//        沉浸式菜单栏
        UIUtils.setImmersiveMenuBar(this);

        bind = ButterKnife.bind(this);

        initData();


    }

    private void initData() {

        //初始化视图控件
        userHead.setVisibility(View.GONE);
        ll_mul_choice.setVisibility(View.GONE);

        //初始化数据
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");

        //设置数据
        if (TextUtils.isEmpty(title)) {
            titleName.setText("咻咻");
        } else {
            titleName.setText(title);
        }

        if (!TextUtils.isEmpty(url)) {

            webview.loadUrl(url);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


        if (bind != null) {
            bind.unbind();
        }

    }
}
