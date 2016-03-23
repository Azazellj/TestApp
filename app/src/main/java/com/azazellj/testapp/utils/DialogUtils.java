package com.azazellj.testapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.azazellj.testapp.R;

/**
 * Created by azazellj on 22.03.16.
 */
public class DialogUtils {

    public static String FIELD_TITLE = "dialog_title";
    public static String FIELD_MESSAGE = "dialog_message";

    public static void showErrorDialog(final Context context, Exception exception) {
        new AlertDialog.Builder(context)
                .setTitle("Oopss..")
                .setMessage("Do ou want to send an email to us?")
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        PhotobuchUtils.startEmailSendingActivity(errorSendingActivity);
                    }
                })
                .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    public static void showNoConnectionErrorDialog(final Activity noConnectionErrorSendingActivity) {
        new AlertDialog.Builder(noConnectionErrorSendingActivity)
                .setTitle("Oopss..")
                .setMessage("Internet connection is now not available")
                .setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }
}
