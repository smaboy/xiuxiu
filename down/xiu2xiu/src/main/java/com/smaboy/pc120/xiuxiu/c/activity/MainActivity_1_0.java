package com.smaboy.pc120.xiuxiu.c.activity;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.base.BaseActivity;
import com.smaboy.pc120.xiuxiu.c.base.BaseFragment;
import com.smaboy.pc120.xiuxiu.c.fragment.LookingFragment;
import com.smaboy.pc120.xiuxiu.c.fragment.MeFragment;
import com.smaboy.pc120.xiuxiu.c.fragment.SmallVDFragment;
import com.smaboy.pc120.xiuxiu.c.fragment.TalkingFragment;
import com.smaboy.pc120.xiuxiu.c.util.LogUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.talking)
    RadioButton talking;
    @BindView(R.id.looking)
    RadioButton looking;
    @BindView(R.id.smallVD)
    RadioButton smallVD;
    @BindView(R.id.me)
    RadioButton me;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.navigation)
    NavigationView navigation;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    private ValueAnimator valueAnimator;//属性动画
    private ArrayList<BaseFragment> fragments;
    private String[] tabs;
    private int curPosition;//当前页面的位置

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

        //初始化内容集合
        fragments = new ArrayList<>();
        fragments.add(new TalkingFragment());
        fragments.add(new LookingFragment());
        fragments.add(new SmallVDFragment());
        fragments.add(new MeFragment());

        //初始化底部标题内容
        tabs = getResources().getStringArray(R.array.mian_buttom_tabs);

        //设置内容,默认首次进入主页，进入到聊天页面
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content, fragments.get(0), Integer.toString(0));
        fragmentTransaction.commit();
        curPosition=0;
        titleName.setVisibility(View.VISIBLE);
        titleName.setText(tabs[curPosition]);

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

    @OnClick({R.id.user_head, R.id.talking, R.id.looking, R.id.smallVD, R.id.me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_head://用户头像的点击事件
                drawerlayout.openDrawer(Gravity.START);
                break;
            case R.id.talking://聊天
                setContentPager(0);


                break;
            case R.id.looking://视界
                setContentPager(1);
                break;
            case R.id.smallVD://看点
                setContentPager(2);
                break;
            case R.id.me://我的
                setContentPager(3);
                break;
        }
    }

    private void setContentPager(int i) {
        //设置当前页面的位置
        curPosition=i;

        //设置标题
        titleName.setText(tabs[curPosition]);


        //设置内容
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragmentByTag = fragmentManager.findFragmentByTag(Integer.toString(i));
        if (fragmentByTag == null) {
            LogUtil.e("我被添加到mangager了" + ",position=" + i);
            fragmentTransaction.add(R.id.content, fragments.get(i), Integer.toString(i));
            fragmentTransaction.commit();


        } else {
            LogUtil.e("我已经被添加到mangager了，只需要显示出来");
            hideAllFragment(fragmentManager, fragmentTransaction);//隐藏fragmentmanger中的fragment
            //显示特定的fragment
            fragmentTransaction.show(fragmentByTag);
            fragmentTransaction.commit();


        }
    }

    private void hideAllFragment(FragmentManager manager, FragmentTransaction transaction) {
        //获取所有的fragment
        List<Fragment> fragments = manager.getFragments();
        for (Fragment fragment : fragments) {
            transaction.hide(fragment);
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }
}
