package com.azazellj.testapp.view.activity;

import android.os.Bundle;

import com.azazellj.testapp.R;
import com.azazellj.testapp.view.fragment.SingleDataFragment;

public class DetailedActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);

        Bundle extras = getIntent().getExtras();

        if (extras == null) {
            finish();
        }

        SingleDataFragment fragment = SingleDataFragment.newInstance();
        fragment.setArguments(extras);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}
