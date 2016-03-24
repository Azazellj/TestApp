package com.azazellj.testapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.azazellj.testapp.adapter.holder.BaseListItemViewHolder;
import com.azazellj.testapp.entity.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azazellj on 22.03.16.
 */
public abstract class BaseListAdapter<E extends Entity, V extends View, VH extends BaseListItemViewHolder<E, V>> extends RecyclerView.Adapter<VH> {
    private List<E> mItems = new ArrayList<>();

    public void setItems(List<E> items) {
        this.mItems = items;
        notifyDataSetChanged();
    }

    public void addItems(List<E> items) {
        this.mItems.addAll(items);
    }

    public E getItem(int position) {
        return this.mItems.get(position);
    }

    public void deleteAll() {
        this.mItems.clear();
    }

    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindViewHolder(final VH holder, final int position);

    @Override
    public long getItemId(int position) {
        return Long.valueOf(getItem(position).getId());
    }

    @Override
    public int getItemCount() {
        return this.mItems.size();
    }
}
