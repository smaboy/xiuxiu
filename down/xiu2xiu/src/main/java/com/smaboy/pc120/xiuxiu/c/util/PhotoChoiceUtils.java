package com.smaboy.pc120.xiuxiu.c.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.activity.MainActivity;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by Smaboy on 2017/12/14-13:29.
 * WHERE IS A WILL,THERE IS A WA!
 */

public class PhotoChoiceUtils  {

    private Context mContext;
    private int PHOTO_REQUEST_TAKEPHOTO=0;
    private int PHOTO_REQUEST_GALLERY=1;
    public PhotoChoiceUtils(Context context) {
        mContext=context;
    }

    public static void showDialog(Context context, View view){
        AlertDialog ad=new AlertDialog.Builder(context).create();
        ad.setView(view);
        ad.show();



    }
    // 拍照部分
    public  void showCamera() {


        final AlertDialog dlg = new AlertDialog.Builder(mContext).create();
        dlg.show();
        Window window = dlg.getWindow();
        // *** 主要就是在这里实现这种效果的.
        // 设置窗口的内容页面,shrew_exit_dialog.xml文件中定义view内容
//        View inflate = LayoutInflater.from(context).inflate(R.layout.alertdialog, null);
//        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) inflate.getLayoutParams();
//        params.width = (int) (DeviceUtils.getScreenWidth((Activity) context)*0.7);
//        params.height = (int) (DeviceUtils.getScreenWidth((Activity) context)*0.7);
//         params.setMargins(5, 5,5,5); // 可以实现设置位置信息，如居左距离，其它类推
//        // params.leftMargin = dip2px(MainActivity.this, 1);
//        inflate.setLayoutParams(params);
        window.setContentView(R.layout.alertdialog);
        // 为确认按钮添加事件,执行退出应用操作
        TextView tv_photo = (TextView) window.findViewById(R.id.tv_photo);
        tv_photo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                 String imageName= getNowTime() + ".png";
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // 指定调用相机拍照后照片的储存路径
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(new File("/sdcard/xiuxiu/", imageName)));
                startActivityForResult((Activity) mContext,intent, PHOTO_REQUEST_TAKEPHOTO,null);
                dlg.cancel();
            }
        });
        TextView tv_album = (TextView) window.findViewById(R.id.tv_album);
        tv_album.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String imageName = getNowTime() + ".png";
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
//                startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
                startActivityForResult((Activity) mContext,intent, PHOTO_REQUEST_GALLERY,null);
                dlg.cancel();
            }
        });

    }

    public static String getNowTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmssSS");
        return dateFormat.format(date);
    }

}
