package com.smaboy.pc120.xiuxiu.c.activity;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.carbs.android.avatarimageview.library.AvatarImageView;

/**
 * 项目名称:down
 * <p>
 * 作者:Administrator
 * <p>
 * 创建时间: 2018/9/16 0016 12:15
 * <p>
 * 类描述:主页面
 */
public class MainActivity_1_0 extends BaseActivity {

    @BindView(R.id.user_head)
    AvatarImageView userHead;
    @BindView(R.id.tab1)
    TextView tab1;
    @BindView(R.id.tab2)
    TextView tab2;
    @BindView(R.id.ll_mul_choice)
    LinearLayout llMulChoice;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.rl_toobar)
    RelativeLayout rlToobar;
    private ValueAnimator valueAnimator;//属性动画

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置布局
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //初始化
        init();
    }

    private void init() {
        //设置颜色随机变化标题栏
        valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(50, 150);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //更新背景颜色
                int currentValue = (int) valueAnimator.getAnimatedValue();
                int argb = Color.argb(255, 255, currentValue, 0);
                rlToobar.setBackgroundColor(argb);
            }
        });
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(1000 * 10);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.start();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //回收属性动画
        if (null != valueAnimator) {
            valueAnimator.cancel();
            valueAnimator = null;
        }
    }
}
