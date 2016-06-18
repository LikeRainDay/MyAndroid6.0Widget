package com.example.houshuai.Recycle;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.houshuai.myandroid60widget.R;

/**
 * Created by HouShuai on 2016/6/18.
 */

public class MyRecycleViewHoder extends RecyclerView.ViewHolder {

    public final ImageView mImageView;
    public final TextView mContentTitle;
    public final TextView mContentSynopsis;

    public MyRecycleViewHoder(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.iv_recyclePicture);
        mContentTitle = (TextView) itemView.findViewById(R.id.tv_contentTitle);
        mContentSynopsis = (TextView) itemView.findViewById(R.id.tv_contentSynopsis);
    }
}
