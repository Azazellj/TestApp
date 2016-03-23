package com.azazellj.testapp.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by azazellj on 22.03.16.
 */
public class TestApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return mContext;
    }
}
