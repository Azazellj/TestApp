package com.azazellj.testapp.utils;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import com.azazellj.testapp.BR;
import com.azazellj.testapp.R;
import com.azazellj.testapp.entity.Picture;

/**
 * Created by azazellj on 22.03.16.
 */
public class DialogUtils {
    public static String broadcastDialogAction = "com.azazellj.testapp.broadcast.alert";

    public static void showErrorDialog(Context context, String message) {
        showDialog(context, R.string.dialog_title_error, message, null);
    }

    public static void showTimeDialog(Context context, String timeStamp, Picture picture) {
        showDialog(context, R.string.dialog_title_time, timeStamp, picture);
    }

    private static void showDialog(Context context, int title, String message, @Nullable Picture picture) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        Dialog dialog;
        dialogBuilder
                .setTitle(title)
                .setMessage(message)
                .setNeutralButton(R.string.ok, null);

        if (picture != null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.picture_item_layout, null, false);
            binding.setVariable(BR.pictureItem, picture);
            dialogBuilder.setView(binding.getRoot());
        }

        dialog = dialogBuilder.create();
        dialog.show();
    }
}
