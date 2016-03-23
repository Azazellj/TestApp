package com.azazellj.testapp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.azazellj.testapp.adapter.PicturesAdapter;
import com.azazellj.testapp.api.UkrBashApi;
import com.azazellj.testapp.entity.Picture;
import com.azazellj.testapp.service.NotifierService;
import com.azazellj.testapp.view.activity.BaseActivity;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    private RecyclerView mUkrBashImageView;
    private SwipeRefreshLayout mRefreshLayout;
    private PicturesAdapter mAdapter;
    private ViewDataBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        ActivityMainBinding binding =
//                DataBindingUtil.setContentView(this, R.layout.activity_main);


//        Picture p = new Picture();
//        binding




//        setContentView(R.layout.activity_main);

        initLayout();

        startService(new Intent(this, NotifierService.class));
    }

    @Override
    public void initLayout() {
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        mRefreshLayout.setOnRefreshListener(this);

        mUkrBashImageView = (RecyclerView) findViewById(R.id.ukrBashImageView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mUkrBashImageView.setLayoutManager(layoutManager);

        mAdapter = new PicturesAdapter();
        setAdapter(Arrays.asList(new Picture[0]));
    }


    private void setAdapter(List<Picture> pictures) {
        mAdapter.setItems(pictures);
        mUkrBashImageView.setAdapter(mAdapter);
    }

    private void showRefreshAnimation(boolean isRefreshing) {
        mRefreshLayout.setRefreshing(isRefreshing);
    }


    @Override
    public void onRefresh() {
        showRefreshAnimation(true);

        UkrBashApi.getInstance().getRandomPictures(new Callback<List<Picture>>() {
            @Override
            public void onResponse(Call<List<Picture>> call, Response<List<Picture>> response) {


                if (response.isSuccessful()) {
                    setAdapter(response.body());
                } else {

                }


                String sss = "";
                showRefreshAnimation(false);
            }

            @Override
            public void onFailure(Call<List<Picture>> call, Throwable t) {


                String ssss = "";
                showRefreshAnimation(false);

            }
        });


    }
}
