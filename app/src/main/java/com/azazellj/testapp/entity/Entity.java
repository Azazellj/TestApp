package com.azazellj.testapp.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by azazellj on 22.03.16.
 */
public class Entity extends BaseObservable {
    private String id;

    public Entity() {
    }

    public Entity(String id) {
        this.id = id;
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
