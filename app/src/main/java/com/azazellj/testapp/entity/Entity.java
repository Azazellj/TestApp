package com.azazellj.testapp.entity;

import android.databinding.BaseObservable;

/**
 * Created by azazellj on 22.03.16.
 */
public class Entity extends BaseObservable {
    public int id;

    public Entity() {
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
