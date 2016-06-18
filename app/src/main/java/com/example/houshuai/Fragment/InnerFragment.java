package com.example.houshuai.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.houshuai.Recycle.ShareRecycleViewAdapter;
import com.example.houshuai.comment.NewsUrlContent;
import com.example.houshuai.myandroid60widget.R;

import java.util.LinkedList;

/**
 * 新闻--内部   fragment
 * Created by HouShuai on 2016/6/18.
 */

public class InnerFragment extends Fragment {

    private RecyclerView mRecycle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.recycle_view, container, false);
        mRecycle = (RecyclerView) mView.findViewById(R.id.recycle);
        return mView;
    }


    /*绑定接口*/
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: 2016/6/18  数据没有做
        mRecycle.setAdapter(new ShareRecycleViewAdapter(getActivity(),new LinkedList<NewsUrlContent>()));

    }
}
