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
public class RefreshFooterLayout extends FrameLayout implements HeadAndFootListener {
    public RefreshFooterLayout(Context context) {
        super(context);
        init(context);
    }

    public RefreshFooterLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RefreshFooterLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        TextView tv = new TextView(context);
        tv.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    public void onEnable(boolean enable) {
        JLog.i("refresh", enable ? "释放后立即加载更多" : "下拉加载更多");
    }

    @Override
    public void onRefreshing() {
        JLog.i("refresh", "正在加载更多。。。");
    }

    @Override
    public void onComlete() {
        JLog.i("refresh", "加载完成");
    }
}
