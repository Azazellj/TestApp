package com.azazellj.testapp.adapter.interfaces;

/**
 * Created by azazellj on 25.03.16.
 */
public interface OnItemActionListener {
    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}