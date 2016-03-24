package com.azazellj.testapp.view.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;

import com.azazellj.testapp.R;
import com.azazellj.testapp.api.UkrBashApi;
import com.azazellj.testapp.entity.Picture;
import com.azazellj.testapp.utils.DialogUtils;
import com.azazellj.testapp.utils.ToastUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by azazellj on 22.03.16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private IntentFilter mIntentFilter = new IntentFilter(DialogUtils.broadcastDialogAction);

    public static final String KEY_BUNDLE_PICTURE = "picture";

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
                    getImageForDialog();
                }
            };

    private void getImageForDialog() {
        UkrBashApi.getInstance().getOnePicture(new Callback<List<Picture>>() {
            @Override
            public void onResponse(Call<List<Picture>> call, Response<List<Picture>> response) {
                workWithResponse(response);
            }

            @Override
            public void onFailure(Call<List<Picture>> call, Throwable t) {
                DialogUtils.showErrorDialog(getBaseContext(), t.getMessage());
            }
        });
    }

    private void workWithResponse(Response<List<Picture>> response) {
        if (!response.isSuccessful()) {
            ToastUtils.showToast(getString(R.string.toast_title_error));
            return;
        }

        if (response.body().size() < 1) return;

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        DialogUtils.showTimeDialog(BaseActivity.this, dateFormat.format(Calendar.getInstance().getTime()), response.body().get(0));
    }
}
