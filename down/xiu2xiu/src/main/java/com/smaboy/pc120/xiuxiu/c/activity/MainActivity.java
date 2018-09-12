package com.smaboy.pc120.xiuxiu.c.activity;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Smaboy on 2017/4/25,22:21
 * Email:405923832@qq.com
 * Better for better
 */

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.base.BaseFragmentActivity;
import com.smaboy.pc120.xiuxiu.c.event.EventMessage;
import com.smaboy.pc120.xiuxiu.c.fragment.LookingFragment;
import com.smaboy.pc120.xiuxiu.c.fragment.MeFragment;
import com.smaboy.pc120.xiuxiu.c.fragment.SmallVDFragment;
import com.smaboy.pc120.xiuxiu.c.fragment.TalkingFragment;
import com.smaboy.pc120.xiuxiu.c.util.EventBusUtils;
import com.smaboy.pc120.xiuxiu.c.util.SelectPicUtil;
import com.smaboy.pc120.xiuxiu.c.util.UIUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import cn.carbs.android.avatarimageview.library.AvatarImageView;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

public class MainActivity extends BaseFragmentActivity implements View.OnClickListener {

    private RadioButton looking;
    private RadioButton smallVD;
    private RadioButton me;
    private RadioButton talking;
    private FrameLayout content;
    public TextView title;
    private NavigationView navigation;
    private AvatarImageView user;
    private DrawerLayout drawerlayout;
    private AvatarImageView iv_user;
    private TextView tv_nick;
    private LinearLayout navigation_head;
    private int PHOTO_REQUEST_TAKEPHOTO = 0;
    private int PHOTO_REQUEST_GALLERY = 1;
    private int PHOTO_REQUEST_CUT = 3;
    private String imageName;//照片路径
    private AlertDialog.Builder adb;


    private FragmentManager fragmentManager;//fragment管理器

    private Context mContext;
    private LinearLayout ll_mul_choice;
    private TextView tab1;
    private TextView tab2;
    public RelativeLayout toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;
        //设置沉浸式菜单栏
        UIUtils.setImmersiveMenuBar(this);

        //去除标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //设置activity的布局
        setContentView(R.layout.activity_main);

        //注册成为订阅者
        EventBus.getDefault().register(this);

        //初始化布局控件
        initView();

        //设置控件的监听
        setListener();

        //设置数据
        setDate();


    }

    private void setDate() {

        //设置cela
        ViewGroup.LayoutParams params = navigation.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels * 7 / 10;
        navigation.setLayoutParams(params);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setListener() {

        talking.setOnClickListener(this);
        looking.setOnClickListener(this);
        smallVD.setOnClickListener(this);
        me.setOnClickListener(this);

        user.setOnClickListener(this);

        iv_user.setOnClickListener(this);
        navigation_head.setOnClickListener(this);
        tv_nick.setOnClickListener(this);

        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this, "選中了" + item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }


    private void initView() {

        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        title = (TextView) findViewById(R.id.title_name);
        user = (AvatarImageView) findViewById(R.id.user_head);
        ll_mul_choice = (LinearLayout) findViewById(R.id.ll_mul_choice);//切换按钮布局
        tab1 = findViewById(R.id.tab1);//切换按钮布局
        tab2 = findViewById(R.id.tab2);//切换按钮布局
        toolbar = findViewById(R.id.rl_toobar);//标题栏

        content = (FrameLayout) findViewById(R.id.content);

        talking = (RadioButton) findViewById(R.id.talking);
        looking = (RadioButton) findViewById(R.id.looking);
        smallVD = (RadioButton) findViewById(R.id.smallVD);
        me = (RadioButton) findViewById(R.id.me);

        navigation = (NavigationView) findViewById(R.id.navigation);
        View headerView = navigation.getHeaderView(0);
        navigation_head = (LinearLayout) headerView.findViewById(R.id.navigation_head);//navigation头部
        iv_user = (AvatarImageView) headerView.findViewById(R.id.iv_user);//navigation头部头像
        tv_nick = (TextView) headerView.findViewById(R.id.tv_nick);//navigation用户昵称

        LinearLayout ll_hongdian = (LinearLayout) navigation.getMenu().findItem(R.id.nav_blog).getActionView();//获取小红点所在布局的实例
        TextView tv_hongdian = (TextView) ll_hongdian.findViewById(R.id.msg);
        tv_hongdian.setText("9");

//        //初始化首页
        //设置页面的切换
        addLayout(1);
        //设置标题的切换
        setTabOneValue();


    }

    //返回数据设置
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //输出图片800*400大小，选择图片时的裁剪比例是2:1
//        bm = SelectPicUtil.onActivityResult(this, requestCode, resultCode, data, 800, 400, 2, 1);
//        if (bm!=null) {
//        }

        if (requestCode == Activity.RESULT_OK) {

            Bitmap bitmap = SelectPicUtil.onActivityResult(this, requestCode, Activity.RESULT_OK, data);
            iv_user.setBitmap(bitmap);
        }
//        if (resultCode == RESULT_OK) {
//            switch (requestCode) {
//                case 0://拍照
//
//                    startPhotoZoom(
//                            Uri.fromFile(new File("/sdcard/fanxin/", imageName)),
//                            480);
//
//
//
//                    break;
//
//                case 1://打开相册
//                    if (data != null)
//                        startPhotoZoom(data.getData(), 480);
//                    break;
//
//                case 3:
//
//                    break;
//
//                default:
//                    break;
//
//            }

        super.onActivityResult(requestCode, resultCode, data);
    }


    private void startPhotoZoom(Uri uri1, int size) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri1, "image/*");
        // crop为true是设置在开启的intent中设置显示的view可以剪裁
        intent.putExtra("crop", "true");

        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        // outputX,outputY 是剪裁图片的宽高
        intent.putExtra("outputX", size);
        intent.putExtra("outputY", size);
        intent.putExtra("return-data", false);

        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.fromFile(new File("/sdcard/fanxin/", imageName)));
        intent.putExtra("outputFormat", Bitmap.CompressFormat.PNG.toString());
        intent.putExtra("noFaceDetection", true); // no face detection
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.talking:

//                Toast.makeText(MainActivity.this, "talking", Toast.LENGTH_SHORT).show();
//                setFrameLayout(R.layout.fragment_talking,new TalkingFragment());

                //设置页面的切换
                addLayout(1);
                //设置标题的切换
                setTabOneValue();


                break;

            case R.id.looking:
//                Toast.makeText(MainActivity.this, "looking", Toast.LENGTH_SHORT).show();
                addLayout(2);
                //设置标题的切换
                setTabTwoValue();

                break;
            case R.id.smallVD:
//                Toast.makeText(MainActivity.this, "video", Toast.LENGTH_SHORT).show();
                addLayout(3);
                //设置标题的切换
                setTabThreeValue();
                break;
            case R.id.me:
//                Toast.makeText(MainActivity.this, "me", Toast.LENGTH_SHORT).show();
                addLayout(4);
                //设置标题的切换
                setTabFourValue();
                break;


            //标题栏用户头像
            case R.id.user_head:
                drawerlayout.openDrawer(navigation);


                break;
            case R.id.iv_user:

//                Toast.makeText(MainActivity.this, "设置头像吗", Toast.LENGTH_SHORT).show();
                setImage();

                break;

            case R.id.navigation_head:
                Toast.makeText(MainActivity.this, "设置背景吗", Toast.LENGTH_SHORT).show();
//                setImage();
                break;

            case R.id.tv_nick:
                Toast.makeText(MainActivity.this, "修改昵称吗", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab1:
                clickTab1();
                break;
            case R.id.tab2:
                clickTab2();
                break;

            default:
                break;


        }

    }
    private void clickTab2() {
        //设置按钮的字体颜色和背景的切换
        tab1.setTextColor(Color.WHITE);
        tab1.setBackgroundResource(R.drawable.left_round_retangle_black_shape);
        tab2.setTextColor(Color.BLACK);
        tab2.setBackgroundResource(R.drawable.right_round_retangle_white_shape);

        //发布订阅，通知看点页面刷新
        EventBusUtils.post(new EventMessage(200));
    }

    private void clickTab1() {
        //设置按钮的字体颜色和背景的切换
        tab1.setTextColor(Color.BLACK);
        tab1.setBackgroundResource(R.drawable.left_round_retangle_white_shape);
        tab2.setTextColor(Color.WHITE);
        tab2.setBackgroundResource(R.drawable.right_round_retangle_black_shape);

        //发布订阅，通知看点页面刷新
        EventBusUtils.post(new EventMessage(100));
    }
    private void setTabOneValue() {
        //设置标题
        title.setVisibility(View.VISIBLE);
        ll_mul_choice.setVisibility(View.GONE);
        title.setText(R.string.main_talk);
        user.setVisibility(View.VISIBLE);

    }
    private void setTabTwoValue() {
        //设置标题
        title.setVisibility(View.VISIBLE);
        ll_mul_choice.setVisibility(View.GONE);
        title.setText(R.string.main_look);
        user.setVisibility(View.GONE);

    }
    private void setTabThreeValue() {
        //设置标题
        title.setVisibility(View.GONE);//隐藏标题
        ll_mul_choice.setVisibility(View.VISIBLE);//显示切换按钮
        clickTab1();//默认切换按钮，选中第一项
        user.setVisibility(View.GONE);

    }
    private void setTabFourValue() {
        //设置标题
        title.setVisibility(View.VISIBLE);
        ll_mul_choice.setVisibility(View.GONE);
        title.setText(R.string.main_me);
        user.setVisibility(View.GONE);

    }

    private void setImage() {
        final int[] flag = {0};
        adb = new AlertDialog.Builder(this);

        adb.setTitle("设置头像")
                .setIcon(R.mipmap.cat)
                .setSingleChoiceItems(new String[]{"拍照", "从相册选取"}, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        Log.e("click", "hahah" + which);
                        flag[0] = which;
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Log.e("click", "确定" + which);
                        Log.e("click", "选择图片来源时，您确定了" + flag[0]);
                        /*获取当前系统的android版本号*/
                        int currentapiVersion = Build.VERSION.SDK_INT;
                        if (flag[0] == 0) {
                            //打开相机
                            if (currentapiVersion < 23) {//23后添加了运行时权限
//                                openCaputer();
                                SelectPicUtil.getByCamera(MainActivity.this);

                            } else {

                                //请求权限
                                requestPermissionPhoto(100);

                            }
                        } else if (flag[0] == 1) {
                            if (currentapiVersion < 23) {//23后添加了运行时权限

//                                openAlbum();
                                SelectPicUtil.getByAlbum(MainActivity.this);


                            } else {

                                //请求权限
                                requestPermissionPhoto(101);

                            }
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();


    }

    private void requestPermissionPhoto(int requestCode) {

        //请求权限
        PermissionGen.with(MainActivity.this)
                .addRequestCode(requestCode)
                .permissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .request();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @PermissionSuccess(requestCode = 100)
    public void doSomething100() {
//        openCaputer();
        SelectPicUtil.getByCamera(this);

    }

    private void openCaputer() {
        imageName = getNowTime() + ".png";
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //指定路径
        File mFile = new File("/sdcard/fanxin/", imageName);
//                // 指定调用相机拍照后照片的储存路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.fromFile(mFile));

        startActivityForResult(intent, PHOTO_REQUEST_TAKEPHOTO);
    }

    @PermissionSuccess(requestCode = 101)
    public void doSomething101() {
//        openAlbum();
        SelectPicUtil.getByAlbum(this);
    }

    @SuppressLint("RestrictedApi")
    private void openAlbum() {
        imageName = getNowTime() + ".png";
        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setDataAndType(
//                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");

        intent.setType("image/*");

        startActivityForResult(intent, PHOTO_REQUEST_GALLERY, null);
    }

    @PermissionFail(requestCode = 100)
    public void doFail100() {
//        Toast.makeText(MainActivity.this, "doFail100", Toast.LENGTH_SHORT).show();

        doSomethingPermissionFail();

    }

    private void doSomethingPermissionFail() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("权限获取失败");
        builder.setMessage("如果不能获得该权限，此功能将不能使用！！");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.setPositiveButton("手动去设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(getAppDetailSettingIntent());
            }
        });
        builder.show();
    }

    @PermissionFail(requestCode = 101)
    public void doFail101() {

        doSomethingPermissionFail();
    }

    /**
     * 获取当前时间。返回字符串
     *
     * @return
     */
    public static String getNowTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmssSS");
        return dateFormat.format(date);
    }

    //添加布局


    private void addLayout(int layout_id) {

        //防止事务多次新建
        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        FragmentTransaction ft = fragmentManager.beginTransaction();

        //遍历隐藏布局
        List<Fragment> fragments = fragmentManager.getFragments();
        for (Fragment fragment : fragments) {

            ft.hide(fragment);
        }

        switch (layout_id) {


            case 1:


                TalkingFragment talkingFragment = (TalkingFragment) fragmentManager.findFragmentByTag(Integer.toString(layout_id));

                if (talkingFragment == null) {

                    ft.add(R.id.content, new TalkingFragment(mContext), Integer.toString(layout_id));
                } else {

                    ft.show(talkingFragment);
                }
                ft.commit();

                break;
            case 2:
                LookingFragment lookingFragment = (LookingFragment) getSupportFragmentManager().findFragmentByTag(Integer.toString(layout_id));

                if (lookingFragment == null) {

                    ft.add(R.id.content, new LookingFragment(mContext), Integer.toString(layout_id));
                } else {

                    ft.show(lookingFragment);
                }
                ft.commit();
                break;
            case 3:
                SmallVDFragment smallVDFragment = (SmallVDFragment) getSupportFragmentManager().findFragmentByTag(Integer.toString(layout_id));

                if (smallVDFragment == null) {

                    ft.add(R.id.content, new SmallVDFragment(mContext), Integer.toString(layout_id));
                } else {

                    ft.show(smallVDFragment);
                }
                ft.commit();
                break;
            case 4:

                MeFragment meFragment = (MeFragment) getSupportFragmentManager().findFragmentByTag(Integer.toString(layout_id));

                if (meFragment == null) {

                    ft.add(R.id.content, new MeFragment(), Integer.toString(layout_id));
                } else {

                    ft.show(meFragment);
                }
                ft.commit();
                break;

            default:
                break;
        }


    }

    /**
     * 获取应用详情页面intent
     *
     * @return
     */
    private Intent getAppDetailSettingIntent() {
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            localIntent.setAction(Intent.ACTION_VIEW);
            localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            localIntent.putExtra("com.android.settings.ApplicationPkgName", getPackageName());
        }
        return localIntent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //注销，订阅者模式
        EventBus.getDefault().unregister(this);

        fragmentManager = null;

        System.gc();
    }

    /**
     *
     * 向外界提供设置标题的方法
     * @param str 标题
     */
    public void setTitle(String str){
        title.setText(str);

    }


    /**
     * 收到消息，会调用此方法，根据不同的消息，做不同的处理
     * 此方法在主线程执行
     * @param message  消息
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventMessage message){

        switch (message.getWhat()) {
            case 0x001 ://设置标题

                title.setText(message.getMessage());
                break;
        }

    }


}

