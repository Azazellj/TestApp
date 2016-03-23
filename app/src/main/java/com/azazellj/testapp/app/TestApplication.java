package com.azazellj.testapp.app;

import android.app.Application;
import android.content.Context;

import com.azazellj.testapp.utils.AppUtils;

/**
 * Created by azazellj on 22.03.16.
 */
public class TestApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();

        if (!AppUtils.isAlarmCreated(AppUtils.TIME_DIALOG_ALARM)) {
            AppUtils.setAlarmManager(AppUtils.TIME_DIALOG_ALARM);
        }
    }

    @Override
    public void onTerminate() {
        AppUtils.cancelAlarmManager(AppUtils.TIME_DIALOG_ALARM);

        super.onTerminate();
    }

    public static Context getAppContext() {
        return mContext;
    }
}
