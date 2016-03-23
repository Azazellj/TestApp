package com.azazellj.testapp.entity;

import android.databinding.BaseObservable;

/**
 * Created by azazellj on 3/23/16.
 */
public class ItemColor extends BaseObservable {
    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
