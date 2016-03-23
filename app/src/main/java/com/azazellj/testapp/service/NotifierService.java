package com.azazellj.testapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by azazellj on 22.03.16.
 */

public class NotifierService extends Service {


    private final IBinder mBinder = new NotifierBinder();


    public NotifierService() {
        Log.e("_", "NotifierService");


    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("_", "onCreate");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("_", "onStartCommand");

        return START_STICKY;
    }

    public class NotifierBinder extends Binder {
        public NotifierService getService() {
            return NotifierService.this;
        }
    }
}
