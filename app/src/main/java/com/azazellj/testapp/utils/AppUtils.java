package com.azazellj.testapp.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

import com.azazellj.testapp.app.TestApplication;
import com.azazellj.testapp.receiver.TimeDialogBroadcastReceiver;

import java.util.Calendar;

/**
 * Created by azazellj on 22.03.16.
 */
public class AppUtils {
    private static final String DEBUG_TAG = "PhotobuchUtils";

    public static Class TIME_DIALOG_ALARM = TimeDialogBroadcastReceiver.class;

    public static int convertDpToPx(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, TestApplication.getAppContext().getResources().getDisplayMetrics());
    }

    public static int getScreenWidth() {
        WindowManager windowManager = (WindowManager) TestApplication.getAppContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);

        return displayMetrics.widthPixels;
    }

    //ALARM METHODS

    public static boolean isAlarmCreated(Class<?> alarmClass) {
        boolean alarmIsCreated = (PendingIntent.getBroadcast(TestApplication.getAppContext(), 0, new Intent(TestApplication.getAppContext(), alarmClass), PendingIntent.FLAG_NO_CREATE) != null);

        if (alarmIsCreated) {
            Log.i(DEBUG_TAG, String.format("Alarm %s is created", alarmClass.getSimpleName()));
        } else {
            Log.i(DEBUG_TAG, String.format("Alarm %s wasn`t created", alarmClass.getSimpleName()));
        }

        return alarmIsCreated;
    }

    public static void setAlarmManager(Class<?> alarmClass) {
        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.MINUTE, 19);

        AlarmManager alarmManager = getAlarmManager();
        Intent alarmReceiver = getAlarmReceiverIntent(alarmClass);

        PendingIntent alarmIntent = getAlarmPendingIntent(0, alarmReceiver, 0);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_HALF_HOUR / 15, alarmIntent);
    }

    public static void cancelAlarmManager(Class<?> alarmClass) {
        AlarmManager alarmManager = getAlarmManager();
        Intent alarmReceiver = getAlarmReceiverIntent(alarmClass);
        PendingIntent alarmIntent = getAlarmPendingIntent(0, alarmReceiver, 0);

        alarmManager.cancel(alarmIntent);
    }

    private static AlarmManager getAlarmManager() {
        return (AlarmManager) TestApplication.getAppContext().getSystemService(Context.ALARM_SERVICE);
    }

    private static Intent getAlarmReceiverIntent(Class<?> alarmClass) {
        return new Intent(TestApplication.getAppContext(), alarmClass);
    }

    private static PendingIntent getAlarmPendingIntent(int requestCode, Intent intent, int flags) {
        return PendingIntent.getBroadcast(TestApplication.getAppContext(), requestCode, intent, flags);
    }

}
