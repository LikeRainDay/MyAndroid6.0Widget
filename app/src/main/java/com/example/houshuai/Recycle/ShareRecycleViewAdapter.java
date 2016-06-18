package com.example.houshuai.Recycle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.houshuai.comment.NewsUrlContent;
import com.example.houshuai.myandroid60widget.R;

import java.util.List;

/**
 * RecycleView的适配器
 * Created by HouShuai on 2016/6/18.
 */

public class ShareRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewHoder> {

    private final LayoutInflater mLayoutInflater;

    public interface OnItemClickListener {
        void OnItemClick(View view,int position);

        void OnItemLongClick(View view, int position);
    }

    public OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    private Context context;
    private List<NewsUrlContent> mDatas;

    public ShareRecycleViewAdapter(Context context, List<NewsUrlContent> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyRecycleViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = mLayoutInflater.inflate(R.layout.recycle_content, parent, false);
        MyRecycleViewHoder mViewHolder = new MyRecycleViewHoder(mView);
        return mViewHolder;
    }
/*
* 绑定ViewHoler,给Item中的控件设置数据
* */
    @Override
    public void onBindViewHolder(final MyRecycleViewHoder holder, final int position) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.OnItemClick(holder.itemView, position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.OnItemLongClick(holder.itemView,position);
                    return true;
                }
            });
            //设置图片
            // TODO: 2016/6/18 加载网络数据
            holder.mImageView.setImageBitmap(null);
            //设置题头
            holder.mContentTitle.setText("");
            //设置概要信息
            holder.mContentSynopsis.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
