package com.smaboy.pc120.xiuxiu.c.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.base.BaseActivity;
import com.smaboy.pc120.xiuxiu.c.interfaces.OnGetPlatformListener;
import com.smaboy.pc120.xiuxiu.c.interfaces.MyOnSendMessageHandler;
import com.smaboy.pc120.xiuxiu.c.util.AlertDialogUtils;
import com.smaboy.pc120.xiuxiu.c.util.FastBlurUtil;
import com.smaboy.pc120.xiuxiu.c.util.LogUtil;
import com.smaboy.pc120.xiuxiu.c.util.PhotoChoiceUtils;
import com.smaboy.pc120.xiuxiu.m.domain.XXUser;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements OnClickListener {


    private int sum = 0;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            switch (msg.what) {
                case 1:


                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    progress.setVisibility(View.GONE);

                    skipPager();


                    return true;

                case 2: //开始发送验证码

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (sum == 60) {
                                rg_send.setClickable(true);
                                rg_send.setText("发送");
                                sum = 0;
                                return;
                            }
                            rg_send.setClickable(false);
                            rg_send.setText((60 - sum) + "S");
                            Message msg = new Message();
                            msg.what = 2;
                            handler.sendMessageDelayed(msg, 1000);

                            sum++;
                        }
                    });

            }
            return false;
        }
    });

    private ImageView iv_background;
    private LinearLayout login;
    private LinearLayout register;
    private Switch switch_login_register;
    private ImageView lg_userhead;
    private AutoCompleteTextView lg_username;
    private EditText lg_pwd;
    private Button lg_login;
    private CheckBox lg_remember_no;
    private CheckBox lg_auto_login;
    private TextView lg_qq;
    private TextView lg_weixin;
    private TextView lg_weibo;
    private EditText rg_phone;
    private Button rg_send;
    private EditText rg_check_no;
    private EditText rg_pwd1;
    private EditText rg_pwd2;
    private Button rg_register;
    private LinearLayout progress;
    private static OnGetPlatformListener onGetPlatformListener;
    private EventHandler smsEventHandler;
    private TextView tv_progress;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

//        初始化
        initView();

        //设置监听
        setListener();
//
        setBackground();

    }


    private void setListener() {

        switch_login_register.setOnClickListener(this);


//        登录
        lg_userhead.setOnClickListener(this);
        lg_username.setOnClickListener(this);
        lg_pwd.setOnClickListener(this);
        lg_login.setOnClickListener(this);
        lg_remember_no.setOnClickListener(this);
        lg_auto_login.setOnClickListener(this);
        lg_qq.setOnClickListener(this);
        lg_weixin.setOnClickListener(this);
        lg_weibo.setOnClickListener(this);
        //注册
        rg_phone.setOnClickListener(this);
        rg_send.setOnClickListener(this);
        rg_check_no.setOnClickListener(this);
        rg_pwd1.setOnClickListener(this);
        rg_pwd2.setOnClickListener(this);
        rg_register.setOnClickListener(this);

        //设置授权回调的监听
        setOnGetPlatformListener();

        //设置短信监听
        setSMSListener();
    }

    private void setSMSListener() {
        // 如果希望在读取通信录的时候提示用户，可以添加下面的代码，并且必须在其他代码调用之前，否则不起作用；如果没这个需求，可以不加这行代码
//        SMSSDK.setAskPermisionOnReadContact(true);

        // 创建EventHandler对象
        smsEventHandler = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {

                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                        LogUtil.e("提交验证码成功" );



                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        //获取验证码成功
                                LogUtil.e("获取验证码成功");

                                //进行环信服务的注册
                                XXUser xxUser = new XXUser(rg_phone.getText().toString(), rg_pwd1.getText().toString(), "", "");
                                registerHX(xxUser);
                            }


                    } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                        //返回支持发送验证码的国家列表
                        LogUtil.e("返回支持发送验证码的国家列表" );
                    }

                else {
                    ((Throwable) data).printStackTrace();

                }

                }
        };

        // 注册监听器
        SMSSDK.registerEventHandler(smsEventHandler);

    }

    private void initView() {

        iv_background = (ImageView) findViewById(R.id.iv_login_register_background);

        login = (LinearLayout) findViewById(R.id.item_login);//初始化登录布局
        register = (LinearLayout) findViewById(R.id.item_register);//初始化注册布局

        progress = (LinearLayout) findViewById(R.id.ll_progress);//加载布局
        tv_progress = (TextView) findViewById(R.id.tv_progress);

        switch_login_register = (Switch) findViewById(R.id.switch_login_register);

        /**
         * 开始登录布局的初始化
         *
         */
        lg_userhead = (ImageView) findViewById(R.id.lg_iv_user_head);
        lg_username = (AutoCompleteTextView) findViewById(R.id.lg_actv_user_name);
        lg_pwd = (EditText) findViewById(R.id.lg_et_pwd);
        lg_login = (Button) findViewById(R.id.lg_btn_login);
        lg_remember_no = (CheckBox) findViewById(R.id.lg_cb_remember_no);
        lg_auto_login = (CheckBox) findViewById(R.id.lg_cb_auto_login);
        lg_qq = (TextView) findViewById(R.id.lg_qq_login);
        lg_weixin = (TextView) findViewById(R.id.lg_weixin_login);
        lg_weibo = (TextView) findViewById(R.id.lg_weibo_login);

        /**
         * 开始注册页面的初始化
         *
         */
        rg_phone = (EditText) findViewById(R.id.rg_et_phone);
        rg_send = (Button) findViewById(R.id.rg_btn_send);
        rg_check_no = (EditText) findViewById(R.id.rg_et_check_no);
        rg_pwd1 = (EditText) findViewById(R.id.rg_et_pwd1);
        rg_pwd2 = (EditText) findViewById(R.id.rg_et_pwd2);
        rg_register = (Button) findViewById(R.id.rg_btn_register);


        //设置默认值
        showLogin();

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setBackground() {

//        Date curDate = new Date(System.currentTimeMillis());//获取当前时间

//        SimpleDateFormat    sDateFormat    =   new SimpleDateFormat("yyyy-MM-dd    hh:mm:ss");
//        String    date    =    sDateFormat.format(new    java.util.Date());


//        取得系统时间,不管是24小时还是12小时  最后都是24
        long time = System.currentTimeMillis();
        Log.e("TAG","当前系统时间毫秒数为:"+time);

        String str = getDateToString(time);
        if (str != null && str != "") {
            int a = str.indexOf(":");
            String curHour = str.substring(a - 2, a);

            int mHour = Integer.parseInt(curHour);

            LogUtil.e("------" + mHour);

            //开始设置图片
//            int n01=(int)(Math.random()*60);  //随机数
            if (mHour < 12) {
//                iv_background.setBackground(getDrawable(R.drawable.login1));
                setMohu(R.drawable.login4);

            } else if (mHour < 18) {
                setMohu(R.drawable.login5);
            } else {
                setMohu(R.drawable.login6);
            }


        }


        LogUtil.e(getDateToString(time) + "****");
//        LogUtil.e(format+"****");
    }

    //    *时间戳转换成字符窜
    public static String getDateToString(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

        return sf.format(d);
    }

    @Override
    public void onClick(View v) {

        TextView tv = new TextView(getApplicationContext());
        tv.setBackground(getResources().getDrawable(R.color.btn_blue_normal));
        switch (v.getId()) {
            case R.id.switch_login_register:
                if (switch_login_register.isChecked()) {
                    showRegister();
                } else {
                    showLogin();
                }

                break;

            case R.id.lg_iv_user_head:

                Toast.makeText(LoginActivity.this, "嘿，小子，别老摸我头！！", Toast.LENGTH_SHORT).show();

                break;


//                登录按钮
            case R.id.lg_btn_login:

                //显示进度
                progress.setVisibility(View.VISIBLE);
                //设置消息，模拟加载过程
                Message msg1 = new Message();
                msg1.what = 1;
                handler.sendMessageDelayed(msg1, 3000);

                break;

            case R.id.lg_cb_remember_no:
                if (lg_remember_no.isChecked()) {
                    Toast.makeText(LoginActivity.this, "记住帐号", Toast.LENGTH_SHORT).show();
                    //将该账号和密码记住，如果登录成功记录在本地否则则置空本次记录


                } else {
                    //无论登录成功与否都不记录此账号
                    Toast.makeText(LoginActivity.this, "不记帐号", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.lg_cb_auto_login:

                if (lg_auto_login.isChecked()) {
                    Toast.makeText(LoginActivity.this, "自动登录", Toast.LENGTH_SHORT).show();
                    //记录此账号和密码，如登录操作成功，则下次进入该应用，将自动登录
                } else {
                    Toast.makeText(LoginActivity.this, "手动登录", Toast.LENGTH_SHORT).show();
                    //无论上次登录成功与否，都不自动登录
                }
                break;

            case R.id.lg_qq_login:

                loginByQQ();
                break;

            case R.id.lg_weixin_login:
                AlertDialogUtils.multiChoiceAlertDialog(this,new String[]{"小样","小红","小猫"},0,null);
//                AlertDialogUtils.simpleAlertDialog(this,null);
//                Toast.makeText(LoginActivity.this, "暂时不支持微信登录，敬请期待！", Toast.LENGTH_SHORT).show();
//                loginByWeiXin();
                break;

            case R.id.lg_weibo_login:

                loginBySinaWeiBo();

                break;


            case R.id.rg_btn_send:

                //进行手机号码判别
                String phone = rg_phone.getText().toString().trim();
                if (11 != phone.length()) {
                    Toast.makeText(LoginActivity.this, "手机号码应为11位有效数字", Toast.LENGTH_SHORT).show();

                } else {
                    SMSSDK.getSupportedCountries();//获取短信目前支持的国家列表
                    LogUtil.e("电话号码:" + rg_phone.getText().toString().trim());
                    SMSSDK.getVerificationCode("86", rg_phone.getText().toString().trim());

                    //发送一个消息，将发送按钮设置为秒表

                    handler.sendEmptyMessage(2);
                }
//


                break;

            case R.id.rg_btn_register:

                //点击注册按钮之后，开始对输入的数据进行分析
                if(rg_phone.getText().toString().isEmpty()||rg_phone.length()!=11) {
                    Toast.makeText(LoginActivity.this, "请正确填写您的手机号！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(rg_check_no.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "验证码不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(rg_pwd1.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(rg_pwd1.length()<9) {
                    Toast.makeText(LoginActivity.this, "密码长度不能小于9位！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(rg_pwd2.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!rg_pwd2.getText().toString().equals(rg_pwd1.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "两次密码不一致，请您再核对一次！", Toast.LENGTH_SHORT).show();
                    return;
                }

                //显示注册加载布局
//                progress.setVisibility(View.VISIBLE);
//                tv_progress.setText("正在注册中...");
//                register.setClickable(false);//设置注册页面不可操作

//                Toast.makeText(LoginActivity.this, "注册", Toast.LENGTH_SHORT).show();
            //对拿到的注册资料进行检查,参数分别为 国家代码，电话号码，验证码
//                提交短信验证码，在监听中返回
            SMSSDK.submitVerificationCode("86", rg_phone.getText().toString(), rg_check_no.getText().toString());


            //验证成功之后在进行环信服务器的注册

            break;
            
            default:
                
                break;

        }
    }

    //设置权限获取成功与否的监听
//    权限获取的信息会回调到这里，我们对信息的处理也在这里
    private void setOnGetPlatformListener() {
        onGetPlatformListener = new OnGetPlatformListener() {
            @Override
            public void getSuccess(Platform arg0, int arg1, HashMap<String, Object> arg2) {

                Log.e("mPlatform", arg1 + "--" + arg2.toString());

                parsePlatformMsg(arg0);
            }

            @Override
            public void getFailture(Platform arg0, int arg1, Throwable arg2) {
                Log.e("mPlatform", arg2.toString());
            }


            @Override
            public void cancel(Platform arg0, int arg1) {
                Log.e("mPlatform", "取消了");
            }
        };
    }

    /**
     * 第三方
     * 登录信息处理
     *
     * @param platform
     */
    private void parsePlatformMsg(Platform platform) {
        String userId = "";
        String pwd = "";
        String userNick = "";
        String userIcon = "";

        Log.e("mPlatform", "开始解析获取到的用户信息");
        Log.e("mPlatform", platform.getName() + ":" + platform.getDb().exportData());


//        if(platform.getName().equals(QQ.NAME)) {
//
//            userId=platform.getDb().get("userID");
//            pwd=platform.getDb().get("userID");
//            userNick=platform.getDb().get("nickname");
//            userIcon=platform.getDb().get("icon");
//
//        }
//        if(platform.getName().equals(Wechat.NAME)) {
//
//
//        }
        userId = platform.getDb().get("userID");
        pwd = platform.getDb().get("userID");
        userNick = platform.getDb().get("nickname");
        userIcon = platform.getDb().get("icon");

        Log.e("mPlatform", userId + "--" + pwd + "---" + userNick + "---" + userIcon);


        //将数据传入注册
        XXUser xxUser = new XXUser(userId, pwd, userIcon, userNick);


        //开始注册环信服务器
        registerHX(xxUser);


    }

    private void registerHX(XXUser xxUser) {
        //注册失败会抛出HyphenateException
//        try {
//            EMClient.getInstance().createAccount(xxUser.getUserId(), xxUser.getUserPwd());//同步方法
//        } catch (HyphenateException e) {
//            e.printStackTrace();
//            Log.e("register",e.toString());
//        }


    }


    private void loginBySinaWeiBo() {
        applyPlatform(SinaWeibo.NAME);
    }

    private void loginByWeiXin() {
        applyPlatform(Wechat.NAME);//授权
    }

    private void loginByQQ() {
        //准备授权
        applyPlatform(QQ.NAME);//授权

    }

    /**
     * 判断是否授权 是的话获取授权信息，不是的话申请授权
     *
     * @param name 授权的第三方应用名称
     */
    public void applyPlatform(String name) {

        Platform platform = ShareSDK.getPlatform(name);
        if (platform.isAuthValid()) {//已经授权，获取授权信息

//            platform.removeAccount(true);

            parsePlatformMsg(platform);

        } else {

            //没有授权，准备申请授权
            startApplyPlatform(platform);

        }


    }

    /**
     * 第三方登录授权
     *
     * @param platform
     */
    private static void startApplyPlatform(Platform platform) {


        platform.SSOSetting(false);  //设置false表示使用SSO授权方式,有客户端优先调用
        platform.setPlatformActionListener(new PlatformActionListener() {//platform.setPlatformActionListener(this); // 设置分享事件回调

            @Override
            public void onError(Platform arg0, int arg1, Throwable arg2) {
                // TODO Auto-generated method stub
                arg2.printStackTrace();

                onGetPlatformListener.getFailture(arg0, arg1, arg2);

            }

            @Override
            public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                // TODO Auto-generated method stub
                Log.e("tag", "------------" + arg2.toString());

                onGetPlatformListener.getSuccess(arg0, arg1, arg2);


            }

            @Override
            public void onCancel(Platform arg0, int arg1) {
                // TODO Auto-generated method stub

                onGetPlatformListener.cancel(arg0, arg1);
            }
        });
//authorize与showUser单独调用一个即可
//        platform.authorize();//单独授权,OnComplete返回的hashmap是空的
        platform.showUser(null);//授权并获取用户信息

////        //获取用户信息
//        //获取用户信息
//        platform.getDb().getPlatformNname();
//        platform.getDb().getToken(); // 获取授权token
//        platform.getDb().getUserId(); // 获取用户在此平台的ID
//        platform.getDb().getUserIcon();//获取用户头像
//        platform.getDb().getUserName(); // 获取用户昵称

// 接下来执行您要的操作

        Log.e("platform", platform.getName() + ":" + platform.getDb().exportData());

    }


    private void showLogin() {
        //设置为登录页面
        register.setVisibility(View.GONE);
        login.setVisibility(View.VISIBLE);
        switch_login_register.setText("登录");
        switch_login_register.setChecked(false);

        //隐藏progress
        progress.setVisibility(View.GONE);
    }

    private void showRegister() {
        //设置为注册页面
        register.setVisibility(View.VISIBLE);
        login.setVisibility(View.GONE);
        switch_login_register.setText("注册");
        switch_login_register.setChecked(true);

        //隐藏progress
        progress.setVisibility(View.GONE);
    }

    /**
     * 设置图片的模糊度
     *
     * @param mInt
     */
    public void setMohu(int mInt) {
        //        获取需要被模糊的原图bitmap
        Resources res = getResources();
        Bitmap scaledBitmap = BitmapFactory.decodeResource(res, mInt);

        //        scaledBitmap为目标图像，10是缩放的倍数（越大模糊效果越高）
        Bitmap blurBitmap = FastBlurUtil.toBlur(scaledBitmap, 2);
        iv_background.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv_background.setImageBitmap(blurBitmap);

    }

    /**
     * 跳转页面
     */
    public void skipPager() {

        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 0) {

            Toast.makeText(LoginActivity.this, "000000", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        //注销短信监听回调接口
        SMSSDK.unregisterEventHandler(smsEventHandler);
    }
}

