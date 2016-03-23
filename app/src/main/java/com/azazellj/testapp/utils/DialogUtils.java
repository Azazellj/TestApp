package com.azazellj.testapp.utils;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.azazellj.testapp.R;

/**
 * Created by azazellj on 22.03.16.
 */
public class DialogUtils {
    public static String broadcastDialogAction = "com.azazellj.testapp.broadcast.alert";

    public static void showErrorDialog(Context context, String message) {
        showDialog(context, R.string.dialog_title_error, message);
    }

    public static void showTimeDialog(Context context, String timeStamp) {
        showDialog(context, R.string.dialog_title_time, timeStamp);
    }

    private static void showDialog(Context context, int title, String message) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        Dialog dialog = dialogBuilder
                .setTitle(title)
                .setMessage(message)
                .setNeutralButton(R.string.ok, null)
                .create();
//        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ERROR);

        dialog.show();
    }
}
