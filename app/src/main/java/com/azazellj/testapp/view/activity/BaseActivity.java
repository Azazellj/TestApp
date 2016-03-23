package com.azazellj.testapp.view.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;

import com.azazellj.testapp.utils.DialogUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by azazellj on 22.03.16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private IntentFilter mIntentFilter = new IntentFilter(DialogUtils.broadcastDialogAction);

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(mBroadcastReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();

        registerReceiver(mBroadcastReceiver, mIntentFilter);
    }

    private BroadcastReceiver mBroadcastReceiver = new
            BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                    DialogUtils.showTimeDialog(BaseActivity.this, dateFormat.format(Calendar.getInstance().getTime()));
                }
            };
}
