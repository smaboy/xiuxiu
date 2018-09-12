package com.smaboy.pc120.xiuxiu.c.interfaces;

import android.graphics.Bitmap;

/**
 * Created by Smaboy on 2017/12/16-0:32.
 * WHERE IS A WILL,THERE IS A WAY!
 */

public interface OnGetBitmapListerner {

    void success (Bitmap bitmap,String path);
    void failture(String e);

}
