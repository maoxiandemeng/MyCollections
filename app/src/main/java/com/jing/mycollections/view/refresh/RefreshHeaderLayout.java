package com.jing.mycollections.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jing.mycollections.R;
import com.jing.mycollections.utils.log.JLog;

/**
 * Created by liu on 2015/11/29.
 */
public class RefreshHeaderLayout extends FrameLayout implements HeadAndFootListener {
    public RefreshHeaderLayout(Context context) {
        super(context);
        init(context);
    }

    public RefreshHeaderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RefreshHeaderLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        TextView tv = new TextView(context);
        tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

    @Override
    public void onEnable(boolean enable) {
        JLog.i("refresh", enable ? "释放后立即刷新" : "下拉刷新");
    }

    @Override
    public void onRefreshing() {
        JLog.i("refresh", "正在刷新。。。");
    }

    @Override
    public void onComlete() {
        JLog.i("refresh", "刷新完成");
    }
}
