package com.azazellj.testapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.azazellj.testapp.utils.DialogUtils;

public class TimeDialogBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(DialogUtils.broadcastDialogAction);

        context.sendBroadcast(broadcastIntent);
    }
}
