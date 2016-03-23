package com.azazellj.testapp.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.azazellj.testapp.R;
import com.azazellj.testapp.adapter.PicturesAdapter;
import com.azazellj.testapp.api.UkrBashApi;
import com.azazellj.testapp.databinding.FragmentRandomDataFragmentBinding;
import com.azazellj.testapp.entity.Picture;
import com.azazellj.testapp.utils.DialogUtils;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by azazellj on 3/23/16.
 */
public class RandomDataFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private FragmentRandomDataFragmentBinding mBinding;
    private PicturesAdapter mAdapter;

    public static RandomDataFragment newInstance() {
        return new RandomDataFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_random_data_fragment, container, false);

        mBinding.refreshLayout.setOnRefreshListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinding.ukrBashImageView.setLayoutManager(layoutManager);

        mAdapter = new PicturesAdapter();
        setAdapter(Arrays.asList(new Picture[0]));

        return mBinding.getRoot();
    }


    private void setAdapter(List<Picture> pictures) {
        mAdapter.setItems(pictures);
        mBinding.ukrBashImageView.setAdapter(mAdapter);
    }

    private void showRefreshAnimation(boolean isRefreshing) {
        mBinding.refreshLayout.setRefreshing(isRefreshing);
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
                    Toast.makeText(getContext(), getString(R.string.toast_title_error), Toast.LENGTH_SHORT).show();
                }
                showRefreshAnimation(false);
            }

            @Override
            public void onFailure(Call<List<Picture>> call, Throwable t) {
                showRefreshAnimation(false);
                DialogUtils.showErrorDialog(getContext(), t.getMessage());
            }
        });
    }
}