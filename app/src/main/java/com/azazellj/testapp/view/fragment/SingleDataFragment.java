package com.azazellj.testapp.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azazellj.testapp.R;
import com.azazellj.testapp.databinding.FragmentSingleDataFragmentBinding;
import com.azazellj.testapp.entity.Picture;
import com.azazellj.testapp.view.activity.BaseActivity;

/**
 * Created by azazellj on 3/23/16.
 */
public class SingleDataFragment extends Fragment {
    protected FragmentSingleDataFragmentBinding mBinding;

    public static SingleDataFragment newInstance() {
        return new SingleDataFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_single_data_fragment, container, false);

        Bundle bundle = getArguments();

        Picture picture = bundle.getParcelable(BaseActivity.KEY_BUNDLE_PICTURE);

        mBinding.setPictureItem(picture);

        return mBinding.getRoot();
    }
}