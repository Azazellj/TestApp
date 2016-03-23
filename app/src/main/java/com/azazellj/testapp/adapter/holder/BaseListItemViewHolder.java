package com.azazellj.testapp.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.azazellj.testapp.entity.Entity;
import com.azazellj.testapp.utils.AppUtils;

/**
 * Created by azazellj on 22.03.16.
 */
public abstract class BaseListItemViewHolder<E extends Entity, V extends View> extends RecyclerView.ViewHolder {
    public BaseListItemViewHolder(V view) {
        super(view);

        RecyclerView.LayoutParams mParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mParams.setMargins(0, 0, 0, AppUtils.convertDpToPx(10));
        view.setLayoutParams(mParams);
    }

    public V getView() {
        return (V) this.itemView;
    }



    public abstract void updateView(E entity);
}
