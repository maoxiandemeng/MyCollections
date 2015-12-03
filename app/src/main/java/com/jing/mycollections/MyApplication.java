package com.jing.mycollections;

import android.app.Application;

import com.jing.mycollections.utils.log.JLog;

/**
 * Created by liu on 2015/11/29.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        JLog.init(BuildConfig.LOG_DEBUG);
    }
}
