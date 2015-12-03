package com.jing.mycollections.view.refresh;

/**
 * Created by liu on 2015/11/29.
 */
public interface HeadAndFootListener {
    void onEnable(boolean enable); //true表示释放去刷新,false保存之前状态
    void onRefreshing();//正在刷新
    void onComlete();//刷新完成
}
