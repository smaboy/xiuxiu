package com.smaboy.pc120.xiuxiu.c.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.base.BaseActivity;
import com.smaboy.pc120.xiuxiu.c.constant.UserInfoTips;
import com.smaboy.pc120.xiuxiu.c.event.EventMessage;
import com.smaboy.pc120.xiuxiu.c.util.EventBusUtils;
import com.smaboy.pc120.xiuxiu.c.util.FastBlurUtil;
import com.smaboy.pc120.xiuxiu.c.util.LogUtil;
import com.smaboy.pc120.xiuxiu.c.util.SPUtils;
import com.smaboy.pc120.xiuxiu.c.util.ThirdPartLoginUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

/**
 * 类名: LoginActivity_1_0
 * 类作用描述: 新的注册页面
 * 作者: Smaboy
 * 创建时间: 2018/9/14 15:05
 */
public class LoginActivity_1_0 extends BaseActivity {

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
    @BindView(R.id.tipl_user_name)
    TextInputLayout tiplUserName;
    @BindView(R.id.tipl_pwd)
    TextInputLayout tiplPwd;
    @BindView(R.id.tipl_rg_phone_no)
    TextInputLayout tiplRgPhoneNo;
    @BindView(R.id.tipl_rg_check_no)
    TextInputLayout tiplRgCheckNo;
    @BindView(R.id.tipl_rg_pwd1)
    TextInputLayout tiplRgPwd1;
    @BindView(R.id.tipl_rg_pwd2)
    TextInputLayout tiplRgPwd2;

    private boolean isLogin = true;//标识当前是登录界面，还是注册界面

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

        setListener();

        initData();
    }

    private void setListener() {
        //设置各输入框监听
        lgActvUserName.addTextChangedListener(new TextWatcher() {

            String str1 = "";

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tiplUserName.setErrorEnabled(false);
                str1 = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().length() > 10) {
                    tiplUserName.setErrorEnabled(true);
                    tiplUserName.setError("用户名不要超过十个字符");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /**
     * 初始化数据
     */
    private void initData() {

        //设置用户名和密码
        lgActvUserName.setText(SPUtils.getInstance(context).getSP(UserInfoTips.USER_NAME));
        lgEtPwd.setText(SPUtils.getInstance(context).getSP(UserInfoTips.USER_PWD));

        //设置记住账号，自动登录状态
        lgCbRememberNo.setChecked("1".equals(SPUtils.getInstance(context).getSP(UserInfoTips.USER_REMEMBER_NO)));
        lgCbAutoLogin.setChecked("1".equals(SPUtils.getInstance(context).getSP(UserInfoTips.USER_AUTO_LOGIN)));

        //登录注册切换的事件监听
        switchLoginRegister.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {//设置为没选中状态
                    isLogin = false;
                    setCurrentPager();

                } else {
                    isLogin = true;
                    setCurrentPager();
                }
            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float sx=0;
        float ex;

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                sx = event.getX();

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                ex=event.getX();
                if(ex-sx>20) {//当左右滑动距离大于20的时候，触发页面切换
                    isLogin=!isLogin;
                    setCurrentPager();
                    return true;
                }

                break;
        }

        return super.onTouchEvent(event);
    }

    //首次进来初始化
    private void init() {
        //初始化布局为登录页面
        setCurrentPager();

        //记住账号，自动登录为不选中装填
        lgCbRememberNo.setChecked(false);
        lgCbAutoLogin.setChecked(false);

        //设置头像

        //隐藏加载框
        llProgress.setVisibility(View.GONE);


        //设置背景图片
        Date date = new Date(System.currentTimeMillis());
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
        String str = simpleDateFormat.format(date);
        LogUtil.e("当前系统时间为:" + date.toString());

        if (!TextUtils.isEmpty(str)) {

            int mHour = Integer.parseInt(str);

            LogUtil.e("当前时间的小时为：" + mHour);

            //开始设置图片
//            int n01=(int)(Math.random()*60);  //随机数
            Bitmap bitmap = FastBlurUtil.toBlur(BitmapFactory.decodeResource(getResources(), R.drawable.login3), 2);
            ivLoginRegisterBackground.setImageBitmap(bitmap);
//            if (mHour < 12) {
////                iv_background.setBackground(getDrawable(R.drawable.login1));
//                Bitmap bitmap = FastBlurUtil.toBlur(BitmapFactory.decodeResource(getResources(), R.drawable.login1), 2);
//                ivLoginRegisterBackground.setImageBitmap(bitmap);
//
//            } else if (mHour < 18) {
//                Bitmap bitmap = FastBlurUtil.toBlur(BitmapFactory.decodeResource(getResources(), R.drawable.login5), 2);
//                ivLoginRegisterBackground.setImageBitmap(bitmap);
//            } else {
//                Bitmap bitmap = FastBlurUtil.toBlur(BitmapFactory.decodeResource(getResources(), R.drawable.login6), 2);
//                ivLoginRegisterBackground.setImageBitmap(bitmap);
//            }


        }

    }

    /**
     * 设置当前页面是登录页面还是注册页面
     */
    private void setCurrentPager() {
        if (isLogin) {
            switchLoginRegister.setChecked(false);
            switchLoginRegister.setText(R.string.login);
            itemLogin.setVisibility(View.VISIBLE);
            itemRegister.setVisibility(View.GONE);

        } else {
            switchLoginRegister.setChecked(true);
            switchLoginRegister.setText(R.string.register);
            itemLogin.setVisibility(View.GONE);
            itemRegister.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //EvntBus解注册
        EventBusUtils.unregister(this);
    }

    //设置点击事件
    @OnClick({R.id.lg_btn_login, R.id.lg_cb_remember_no, R.id.lg_cb_auto_login, R.id.lg_qq_login, R.id.lg_weixin_login, R.id.lg_weibo_login, R.id.rg_btn_send, R.id.rg_btn_register, R.id.switch_login_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lg_btn_login://登录
                go2MainActivity();

                break;
            case R.id.lg_cb_remember_no://记住账号
                if (lgCbRememberNo.isChecked()) {
                    SPUtils.getInstance(this).putSP(UserInfoTips.USER_REMEMBER_NO, "1");//添加记住账号标识
                    SPUtils.getInstance(this).putSP(UserInfoTips.USER_NAME, lgActvUserName.getText().toString());//保存姓名


                } else {
                    lgCbAutoLogin.setChecked(false);//不记住账户，自动登录也取消
                    SPUtils.getInstance(this).removeSP(UserInfoTips.USER_AUTO_LOGIN);//移除自动登录标识
                    SPUtils.getInstance(this).removeSP(UserInfoTips.USER_REMEMBER_NO);//移除记住账号标识
                    SPUtils.getInstance(this).removeSP(UserInfoTips.USER_NAME);//移除姓名
                    SPUtils.getInstance(this).removeSP(UserInfoTips.USER_PWD);//移除密码
                }

                break;
            case R.id.lg_cb_auto_login://自动登录
                if (lgCbAutoLogin.isChecked()) {//点选中状态
                    lgCbRememberNo.setChecked(true);//记住账号也会变为选中状态
                    SPUtils.getInstance(this).putSP(UserInfoTips.USER_AUTO_LOGIN, "1");//添加自动登录标识
                    SPUtils.getInstance(this).putSP(UserInfoTips.USER_REMEMBER_NO, "1");//添加记住账号标识
                    SPUtils.getInstance(this).putSP(UserInfoTips.USER_NAME, lgActvUserName.getText().toString());//保存姓名
                    SPUtils.getInstance(this).putSP(UserInfoTips.USER_PWD, lgEtPwd.getText().toString());//保存密码

                } else {//没选中状态
                    SPUtils.getInstance(this).removeSP(UserInfoTips.USER_AUTO_LOGIN);//移除自动登录标识
                    SPUtils.getInstance(this).removeSP(UserInfoTips.USER_PWD);//移除密码
                }
                break;
            case R.id.lg_qq_login://qq登录
                ThirdPartLoginUtils.getPlatform(QQ.NAME, false, false, new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        LogUtil.e(platform.getDb().getUserId());
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });
                break;
            case R.id.lg_weixin_login://微信登录
                ThirdPartLoginUtils.getPlatform(Wechat.NAME, false, false, new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        LogUtil.e(platform.getDb().getUserId());
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });
                break;
            case R.id.lg_weibo_login://新浪微博登录
                ThirdPartLoginUtils.getPlatform(SinaWeibo.NAME, false, false, new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        LogUtil.e(platform.getDb().getUserId());
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });
                break;
            case R.id.rg_btn_send://发送
                break;
            case R.id.rg_btn_register://注册
                break;
            case R.id.switch_login_register://登录注册切换按钮


                break;
        }
    }

    private void go2MainActivity() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity_1_0.class);
        startActivity(intent);

    }

    /**
     * Eventbus消息处理
     *
     * @param messageEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void doEvent(EventMessage messageEvent) {

    }


}
