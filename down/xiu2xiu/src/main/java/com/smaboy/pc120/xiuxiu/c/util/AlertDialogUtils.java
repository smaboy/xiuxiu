package com.smaboy.pc120.xiuxiu.c.util;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smaboy.pc120.xiuxiu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类名: AlertDialogUtils
 * 类作用描述: java类作用描述
 * 作者: Smaboy
 * 创建时间: 2018/9/20 10:53
 */
public class AlertDialogUtils {

    /**
     * 该方法显示一个内容和，确定、取消 按钮的dialog
     *
     * @param context 上下文
     * @param title  标题
     * @param content 内容
     * @param sure 确定的点击回调
     */
    public static void showHintDialog(Context context, String title, String content, View.OnClickListener sure) {
        final Dialog dialog = new Dialog(context, R.style.Dialog_Fullscreen);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_hint, null);
        dialog.setContentView(view);
        ViewHolder viewHolder = new ViewHolder(view);

        //适配布局的宽度。默认为屏幕宽度的0.7
        ViewGroup.LayoutParams layoutParams = viewHolder.llDialogHint.getLayoutParams();
        layoutParams.width= (int) (context.getResources().getDisplayMetrics().widthPixels*0.7);
        viewHolder.llDialogHint.setLayoutParams(layoutParams);

        //设置数据
        viewHolder.tvTitle.setText(title);
        viewHolder.tvContent.setText(content);
        //设置点击确定的监听
        viewHolder.tvSure.setOnClickListener(sure);

        //设置点击外围和取消事件
        viewHolder.tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        viewHolder.flDialogHintOutside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });


        dialog.show();

    }

    static class ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.tv_cancel)
        TextView tvCancel;
        @BindView(R.id.tv_sure)
        TextView tvSure;
        @BindView(R.id.ll_dialog_hint)
        LinearLayout llDialogHint;
        @BindView(R.id.fl_dialog_hint_outside)
        FrameLayout flDialogHintOutside;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
