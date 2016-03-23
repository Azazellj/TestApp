package com.azazellj.testapp.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azazellj.testapp.BR;
import com.azazellj.testapp.R;
import com.azazellj.testapp.adapter.holder.PictureViewHolder;
import com.azazellj.testapp.entity.Picture;

/**
 * Created by azazellj on 22.03.16.
 */
public class PicturesAdapter extends BaseListAdapter<Picture, View, PictureViewHolder> {
    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        ViewDataBinding binding = holder.getBinding();
        Picture item = getItem(position);
        binding.setVariable(BR.pictureItem, item);
        binding.executePendingBindings();
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.picture_item, parent, false);

        return new PictureViewHolder(binding.getRoot());
    }
}
