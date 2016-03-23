package com.azazellj.testapp.view.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by azazellj on 22.03.16.
 */
public abstract class BaseActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {


    public abstract void initLayout();

    public void showDialog(String title, String message) {

    }

}
