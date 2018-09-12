package com.smaboy.pc120.xiuxiu.c.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smaboy.pc120.xiuxiu.R;
import com.smaboy.pc120.xiuxiu.c.activity.NewsDetailWeb;
import com.smaboy.pc120.xiuxiu.m.domain.NewsTopEntity;

import java.util.ArrayList;

/**
 * Created by Smaboy on 2018/7/13-13:42.
 * WHERE IS A WILL,THERE IS A WAY!
 */
public class LookingNewsTopFragmentAdapter extends RecyclerView.Adapter<LookingNewsTopFragmentAdapter.MyHolder> {


    private ArrayList<NewsTopEntity.ResultBean.DataBean> data;
    private Context mContext;

    public LookingNewsTopFragmentAdapter(ArrayList<NewsTopEntity.ResultBean.DataBean> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        //分两种类型，一张图片，两张图，三张图片
        if (viewType==3) {//采用三张图布局
            view = LayoutInflater.from(mContext).inflate(R.layout.fragment_looking_news_item_3, parent, false);
        } else if (viewType==2) {
            view = LayoutInflater.from(mContext).inflate(R.layout.fragment_looking_news_item_2, parent, false);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.fragment_looking_news_item_1, parent, false);

        }

        MyHolder holder = new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {

//        //绑定数据
        holder.title.setText(data.get(position).getTitle());

        if (holder.image1!=null)
        Glide.with(mContext)
                .load(data.get(position).getThumbnail_pic_s()).error( R.drawable.man) //异常时候显示的图片
                .placeholder( R.drawable.man) //加载成功前显示的图片
                .fallback( R.drawable.man) //url为空的时候,显示的图片
                .into(holder.image1);//在RequestBuilder 中使用自定义的ImageViewTarget
        if (holder.image2!=null)
        Glide.with(mContext)
                .load(data.get(position).getThumbnail_pic_s02()).error( R.drawable.man) //异常时候显示的图片
                .placeholder( R.drawable.man) //加载成功前显示的图片
                .fallback( R.drawable.man) //url为空的时候,显示的图片
                .into(holder.image2);//在RequestBuilder 中使用自定义的ImageViewTarget
        if (holder.image3!=null)
            Glide.with(mContext)
                    .load(data.get(position).getThumbnail_pic_s03()).error( R.drawable.man) //异常时候显示的图片
                    .placeholder( R.drawable.man) //加载成功前显示的图片
                    .fallback( R.drawable.man) //url为空的时候,显示的图片
                    .into(holder.image3);//在RequestBuilder 中使用自定义的ImageViewTarget

        holder.authorName.setText(data.get(position).getAuthor_name());
        holder.date.setText(data.get(position).getDate());


        //设置监听
        //设置每项item的监听
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(mContext, "哈哈", Toast.LENGTH_SHORT).show();
//                点击之后跳转到新闻详情页
//                EventMessage message=new EventMessage();
//                message.setWhat(EventMessage.NEWS_DETAILS_WEB);
//                Bundle bundle=new Bundle();
//                bundle.putCharSequence("url",data.get(position).getUrl());
//                EventBus.getDefault().post(message);
                Intent intent=new Intent(mContext, NewsDetailWeb.class);
                intent.putExtra("url",data.get(position).getUrl());
                intent.putExtra("title",data.get(position).getAuthor_name());
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {

        //分两种类型，一张图片，两张图，三张图片
        String thumbnail_pic_s03 = data.get(position).getThumbnail_pic_s03();
        String thumbnail_pic_s02 = data.get(position).getThumbnail_pic_s02();
        String thumbnail_pic_s01 = data.get(position).getThumbnail_pic_s();
        if (!TextUtils.isEmpty(thumbnail_pic_s03)) {//采用三张图布局
            return 3;
        } else if (!TextUtils.isEmpty(thumbnail_pic_s02)) {
            return 2;
        } else if (!TextUtils.isEmpty(thumbnail_pic_s01)){
            return 1;

        }
        return 0;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image1;
        ImageView image2;
        ImageView image3;
        TextView authorName;
        TextView date;
        CardView cardview;

        MyHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            image1=itemView.findViewById(R.id.image_1);
            image2=itemView.findViewById(R.id.image_2);
            image3=itemView.findViewById(R.id.image_3);
            authorName=itemView.findViewById(R.id.author_name);
            date=itemView.findViewById(R.id.date);
            cardview=itemView.findViewById(R.id.cardview);

        }


    }
}
