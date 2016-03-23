package com.azazellj.testapp.adapter.holder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

import com.azazellj.testapp.entity.Picture;
import com.azazellj.testapp.view.PictureCardView;

/**
 * Created by azazellj on 22.03.16.
 */
public class PictureViewHolder extends BaseListItemViewHolder<Picture, PictureCardView> {



    public PictureViewHolder(PictureCardView view) {
        super(view);
    }

    public ViewDataBinding getBinding() {
        return DataBindingUtil.getBinding(getView());
    }

    @Override
    public void updateView(Picture picture) {
//        UserItemBinding
//
//                ActivityMainBinding.
        getView().updateView(picture);
    }
}
