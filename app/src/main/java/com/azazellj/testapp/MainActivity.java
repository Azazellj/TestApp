package com.azazellj.testapp;

import android.os.Bundle;

import com.azazellj.testapp.view.activity.BaseActivity;
import com.azazellj.testapp.view.fragment.RandomDataFragment;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, RandomDataFragment.newInstance()).commit();

////        DialogUtils.showTimeDialog(this, "SSSS");
//        IntentFilter filter = new IntentFilter(broadcast);
//
//        this.registerReceiver(broadcastReceiver, filter);

    }


//    private BroadcastReceiver broadcastReceiver = new
//            BroadcastReceiver() {
//                @Override
//                public void onReceive(Context context, Intent intent) {
//
//                    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
////
//            DialogUtils.showTimeDialog(MainActivity.this, dateFormat.format(Calendar.getInstance().getTime()));
////
//
//
//                    String ss = "";
//
//                }
//            };

//    public class TimeDialogBroadcastReceiver extends BroadcastReceiver {
//        public TimeDialogBroadcastReceiver() {
//        }
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
////        PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
////        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
////        wakeLock.acquire();
//
//            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
//
//            DialogUtils.showTimeDialog(MainActivity.this, dateFormat.format(Calendar.getInstance().getTime()));
//
////        wakeLock.release();
//        }
//    }
}
