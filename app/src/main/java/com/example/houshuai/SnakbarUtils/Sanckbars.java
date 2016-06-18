package com.example.houshuai.SnakbarUtils;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.example.houshuai.myandroid60widget.R;

/**
 * Created by HouShuai on 2016/6/18.
 */

public class Sanckbars {
    private static Snackbar mSnacker;
    public static void show(View view, String content, int state) {
        if (state != 0) {
            //设置长时间提示
            mSnacker = Snackbar.make(view, content, Snackbar.LENGTH_LONG);
        } else {//短时间
            mSnacker = Snackbar.make(view, content, Snackbar.LENGTH_SHORT);
        }
mSnacker.show();
        mSnacker.setAction(R.string.close, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSnacker.getClass();
            }
        });
    }
}
