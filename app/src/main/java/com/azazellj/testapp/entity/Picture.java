package com.azazellj.testapp.entity;

import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by azazellj on 04.12.15.
 */
public class Picture extends Entity {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Picture createFromParcel(Parcel in) {
            return new Picture(in);
        }

        public Picture[] newArray(int size) {
            return new Picture[size];
        }
    };

    private String status; // 1 – неопублікована, 2 — опублікована, 0 — видалена
    private String type; // picture
    private String add_date;// дата додавання, unix time
    private String pub_date; // дата публікації, unix time, 0 якщо status=1
    private String author; // login або анонім
    private String author_id; // ID автора, 0 якщо анонім
    private String image;// картинка 400х400
    private String thumbnail; // картинка 150х150
    private String title; // назва картинки
    private String rating; // рейтинг
    private boolean detailMode = false;

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    @Bindable
    public boolean isDetailMode() {
        return detailMode;
    }

    public void setDetailMode(boolean detailMode) {
        this.detailMode = detailMode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Picture(Parcel in) {
        String[] data = new String[12];
        in.readStringArray(data);
        setId(data[0]);
        this.status = data[1];
        this.type = data[2];
        this.add_date = data[3];
        this.pub_date = data[4];
        this.author = data[5];
        this.author_id = data[6];
        this.image = data[7];
        this.thumbnail = data[8];
        this.title = data[9];
        this.rating = data[10];
        this.detailMode = Boolean.parseBoolean(data[11]);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                getId(),
                this.status,
                this.type,
                this.add_date,
                this.pub_date,
                this.author,
                this.author_id,
                this.image,
                this.thumbnail,
                this.title,
                this.rating,
                String.valueOf(this.detailMode)
        });
    }
}
