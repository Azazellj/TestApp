package com.azazellj.testapp.utils;

import android.widget.Toast;

import com.azazellj.testapp.R;
import com.azazellj.testapp.app.TestApplication;

/**
 * Created by azazellj on 3/24/16.
 */
public class ToastUtils {
    public static void showToast(String message) {
        Toast.makeText(TestApplication.getAppContext(), TestApplication.getAppContext().getString(R.string.toast_title_error), Toast.LENGTH_SHORT).show();
    }
}
