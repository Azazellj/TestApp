package com.azazellj.testapp.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

import com.azazellj.testapp.app.TestApplication;

/**
 * Created by azazellj on 22.03.16.
 */
public class AppUtils {

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

}
