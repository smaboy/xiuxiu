package com.smaboy.pc120.xiuxiu.c.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.TextView;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.base.BaseActivity;
import com.smaboy.pc120.xiuxiu.c.util.PackageHelpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称:down
 * <p>
 * 作者:Administrator
 * <p>
 * 创建时间: 2018/9/16 0016 10:43
 * <p>
 * 类描述:欢迎界面
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.tv_app_name)
    TextView tvAppName;
    @BindView(R.id.tv_version_name)
    TextView tvVersionName;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {

            switch (message.what) {
                case 0:

                    break;
                case 1:

                    startActivity(new Intent(SplashActivity.this, LoginActivity_1_0.class));
                    finish();
                    break;
            }
            return false;
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置布局
        setContentView(R.layout.splash_activity);

        //设置注释绑定
        ButterKnife.bind(this);

        //设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        initData();

    }

    private void initData() {
        //设置app名称和版本号
        tvAppName.setText(R.string.app_name);
        tvVersionName.setText(PackageHelpUtils.getVersionName(context));

    }

    @Override
    protected void onResume() {
        super.onResume();

        Message message = new Message();
        message.what = 1;
        handler.sendMessageDelayed(message, 2000);
    }
}
