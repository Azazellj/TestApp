package com.azazellj.testapp.entity;

import android.databinding.Bindable;

/**
 * Created by azazellj on 04.12.15.
 */
public class Picture extends Entity {
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
    private boolean detailMode;

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
}
