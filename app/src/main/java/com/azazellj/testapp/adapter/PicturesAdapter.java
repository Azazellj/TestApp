package com.azazellj.testapp.adapter;

import android.view.ViewGroup;

import com.azazellj.testapp.BR;
import com.azazellj.testapp.adapter.holder.PictureViewHolder;
import com.azazellj.testapp.entity.Picture;
import com.azazellj.testapp.view.PictureCardView;

/**
 * Created by azazellj on 22.03.16.
 */
public class PicturesAdapter extends BaseListAdapter<Picture, PictureCardView, PictureViewHolder> {
    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {

        holder.
                getBinding()
                .setVariable(BR.pictureItem, getItem(position));
        holder.getBinding().executePendingBindings();


//        holder.updateView(getItem(position));
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PictureViewHolder(new PictureCardView(parent.getContext()));
    }
}
