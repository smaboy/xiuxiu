package com.smaboy.pc120.xiuxiu.c.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.MessageEvent;
import com.smaboy.pc120.xiuxiu.c.base.BaseFragmentActivity;
import com.smaboy.pc120.xiuxiu.c.util.EventBusUtils;
import com.smaboy.pc120.xiuxiu.c.util.FastBlurUtil;
import com.smaboy.pc120.xiuxiu.c.util.LogUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.sql.Date;
import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 类名: LoginActivity_1_0
 * 类作用描述: 新的注册页面
 * 作者: Smaboy
 * 创建时间: 2018/9/14 15:05
 */
public class LoginActivity_1_0 extends BaseFragmentActivity {

    @BindView(R.id.iv_login_register_background)
    ImageView ivLoginRegisterBackground;
    @BindView(R.id.lg_iv_user_head)
    ImageView lgIvUserHead;
    @BindView(R.id.lg_actv_user_name)
    AutoCompleteTextView lgActvUserName;
    @BindView(R.id.lg_et_pwd)
    EditText lgEtPwd;
    @BindView(R.id.lg_btn_login)
    Button lgBtnLogin;
    @BindView(R.id.lg_cb_remember_no)
    CheckBox lgCbRememberNo;
    @BindView(R.id.lg_cb_auto_login)
    CheckBox lgCbAutoLogin;
    @BindView(R.id.lg_qq_login)
    TextView lgQqLogin;
    @BindView(R.id.lg_weixin_login)
    TextView lgWeixinLogin;
    @BindView(R.id.lg_weibo_login)
    TextView lgWeiboLogin;
    @BindView(R.id.item_login)
    LinearLayout itemLogin;
    @BindView(R.id.rg_et_phone)
    EditText rgEtPhone;
    @BindView(R.id.rg_btn_send)
    Button rgBtnSend;
    @BindView(R.id.rg_et_check_no)
    EditText rgEtCheckNo;
    @BindView(R.id.rg_et_pwd1)
    EditText rgEtPwd1;
    @BindView(R.id.rg_et_pwd2)
    EditText rgEtPwd2;
    @BindView(R.id.rg_btn_register)
    Button rgBtnRegister;
    @BindView(R.id.item_register)
    LinearLayout itemRegister;
    @BindView(R.id.switch_login_register)
    Switch switchLoginRegister;
    @BindView(R.id.tv_progress)
    TextView tvProgress;
    @BindView(R.id.ll_progress)
    LinearLayout llProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置布局
        setContentView(R.layout.activity_login_1_0);
        //绑定黄油刀
        ButterKnife.bind(this);

        //EvntBus注册
        EventBusUtils.register(this);

        init();
    }

    //首次进来初始化
    private void init() {
        //设置背景图片
        Date date = new Date(System.currentTimeMillis());
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
        String str = simpleDateFormat.format(date);
        LogUtil.e("当前系统时间为:"+date.toString());

        if (!TextUtils.isEmpty(str)) {

            int mHour = Integer.parseInt(str);

            LogUtil.e("当前时间的小时为：" + mHour);

            //开始设置图片
//            int n01=(int)(Math.random()*60);  //随机数
            if (mHour < 12) {
//                iv_background.setBackground(getDrawable(R.drawable.login1));
                Bitmap bitmap = FastBlurUtil.toBlur(BitmapFactory.decodeResource(getResources(), R.drawable.login1), 2);
                ivLoginRegisterBackground.setImageBitmap(bitmap);

            } else if (mHour < 18) {
                Bitmap bitmap = FastBlurUtil.toBlur(BitmapFactory.decodeResource(getResources(), R.drawable.login5), 2);
                ivLoginRegisterBackground.setImageBitmap(bitmap);
            } else {
                Bitmap bitmap = FastBlurUtil.toBlur(BitmapFactory.decodeResource(getResources(), R.drawable.login6), 2);
                ivLoginRegisterBackground.setImageBitmap(bitmap);
            }


        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //EvntBus解注册
        EventBusUtils.unregister(this);
    }

    @OnClick({R.id.lg_btn_login, R.id.lg_cb_remember_no, R.id.lg_cb_auto_login, R.id.lg_qq_login, R.id.lg_weixin_login, R.id.lg_weibo_login, R.id.rg_btn_send, R.id.rg_btn_register, R.id.switch_login_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lg_btn_login://登录
                break;
            case R.id.lg_cb_remember_no://记住账号
                break;
            case R.id.lg_cb_auto_login://自动登录
                break;
            case R.id.lg_qq_login://qq登录
                break;
            case R.id.lg_weixin_login://微信登录
                break;
            case R.id.lg_weibo_login://新浪微博登录
                break;
            case R.id.rg_btn_send://发送
                break;
            case R.id.rg_btn_register://注册
                break;
            case R.id.switch_login_register://登录注册切换按钮
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void doEvent(MessageEvent messageEvent){

    }

}
