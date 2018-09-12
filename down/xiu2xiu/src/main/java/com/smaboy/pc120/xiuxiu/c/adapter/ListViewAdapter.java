package com.smaboy.pc120.xiuxiu.c.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.m.domain.JokeEnty;
import com.smaboy.pc120.xiuxiu.m.domain.WeiXinChoiceEntity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by 40592 on 2018/7/21-12:54.
 * WHERE IS A WILL,THERE IS A WAY!
 */
public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<WeiXinChoiceEntity.ResultBean.ListBean> lists;

    public ListViewAdapter(Context mContext, ArrayList<WeiXinChoiceEntity.ResultBean.ListBean> lists) {
        this.mContext = mContext;
        this.lists = lists;

    }

    @Override
    public int getCount() {

        return lists == null ? 0 : lists.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view == null) {

            view = LayoutInflater.from(mContext).inflate(R.layout.fragment_looking_news_item_1, viewGroup, false);

            holder = new ViewHolder();
            holder.title = view.findViewById(R.id.title);
            holder.source = view.findViewById(R.id.author_name);
            holder.time = view.findViewById(R.id.date);
            holder.firstImg = view.findViewById(R.id.image_1);

            view.setTag(holder);


        } else {

            holder = (ViewHolder) view.getTag();
        }

        //设置数据
        holder.title.setText(lists.get(i).getTitle());
        holder.source.setText(lists.get(i).getSource());
        holder.firstImg.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .load(lists.get(i).getFirstImg()).error(R.drawable.man) //异常时候显示的图片
                .placeholder(R.drawable.man) //加载成功前显示的图片
                .fallback(R.drawable.man) //url为空的时候,显示的图片
                .into(holder.firstImg);//在RequestBuilder 中使用自定义的ImageViewTarget


        return view;
    }


    class ViewHolder {
        private TextView title;
        private TextView source;
        private TextView time;
        private ImageView firstImg;

    }


    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<WeiXinChoiceEntity.ResultBean.ListBean> addMessageList) {
        //增加数据
        int position = lists.size();
        lists.addAll(position, addMessageList);
//        notifyItemInserted(position);
        notifyAll();

    }

    public void refresh(List<WeiXinChoiceEntity.ResultBean.ListBean> newList) {
        //刷新数据
        lists.removeAll(lists);
        lists.addAll(newList);
        notifyDataSetChanged();
    }

    public String getCurTime() {
//        取得系统时间,不管是24小时还是12小时  最后都是24
        long time = System.currentTimeMillis();
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

        return sf.format(d);

    }


}
