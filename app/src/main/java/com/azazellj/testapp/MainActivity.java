package com.azazellj.testapp;

import android.os.Bundle;

import com.azazellj.testapp.view.activity.BaseActivity;
import com.azazellj.testapp.view.fragment.RandomDataFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, RandomDataFragment.newInstance()).commit();
    }
}
