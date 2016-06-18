package com.example.houshuai.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.houshuai.Inter.MainToFirstNP;
import com.example.houshuai.myandroid60widget.R;

import java.util.LinkedList;

/**            新闻
 * Created by HouShuai on 2016/6/18.
 */

public class FirstNewsPager extends android.support.v4.app.Fragment implements MainToFirstNP{

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LinkedList<Fragment> fragments;
    private int mPosition;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fg_show_news, container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.srl_refreshDatas);
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //准备内部fragment
        initFragment();
        //更新内部信息的数据
        UpdataInerFragmentDatas();
        mSwipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary);

    }

    private void UpdataInerFragmentDatas() {
        /*更新数据*/
      mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
          @Override
          public void onRefresh() {
              // TODO: 2016/6/18 更新数据 执行异步数据去下载数据
              new Handler().postDelayed(new Runnable() {
                  @Override
                  public void run() {
                  mSwipeRefreshLayout.setRefreshing(false);
                      //传递数据到内部fragment
                      // TODO: 2016/6/18 刷新
                  }
              },1000);
          }
      });
    }


    private void initFragment() {
        fragments = new LinkedList<>();
        String[] stringArray = getResources().getStringArray(R.array.Top_title);
        for (int i = 0; i < stringArray.length; i++) {
            fragments.add(new InnerFragment());
        }
    }

    @Override
    public void sendCurrentItem(int position) {
        mPosition = position;
    }
}
