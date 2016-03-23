package com.azazellj.testapp.adapter.holder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;

import com.azazellj.testapp.entity.Picture;

/**
 * Created by azazellj on 22.03.16.
 */
public class PictureViewHolder extends BaseListItemViewHolder<Picture, View> {

    public PictureViewHolder(View view) {
        super(view);
    }

    public ViewDataBinding getBinding() {
        return DataBindingUtil.getBinding(itemView);
    }
}
