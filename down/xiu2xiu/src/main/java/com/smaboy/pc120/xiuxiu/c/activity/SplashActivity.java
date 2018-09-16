package com.smaboy.pc120.xiuxiu.c.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.widget.TextView;

import com.smaboy.pc120.xiuxiu.c.base.BaseActivity;

/**
 * 项目名称:down
 * <p>
 * 作者:Administrator
 * <p>
 * 创建时间: 2018/9/16 0016 10:43
 * <p>
 * 类描述:
 */
public class SplashActivity extends BaseActivity {

    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {

            switch (message.what) {
                case 0 :

                    break;
                case 1 :

                    startActivity(new Intent(SplashActivity.this,LoginActivity_1_0.class));
                    finish();
                    break;
            }
            return false;
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView=new TextView(this);
        textView.setText("欢迎使用");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(45);
        setContentView(textView);



    }

    @Override
    protected void onResume() {
        super.onResume();

        Message message=new Message();
        message.what=1;
        handler.sendMessageDelayed(message,2000);
    }
}