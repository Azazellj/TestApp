package com.azazellj.testapp.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by azazellj on 22.03.16.
 */
public class Entity extends BaseObservable implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Entity createFromParcel(Parcel in) {
            return new Entity(in);
        }

        public Entity[] newArray(int size) {
            return new Entity[size];
        }
    };

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

    public Entity(Parcel in) {
        String[] data = new String[1];
        in.readStringArray(data);
        this.id = data[0];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.id});
    }
}
