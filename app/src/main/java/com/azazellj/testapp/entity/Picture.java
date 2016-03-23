package com.azazellj.testapp.entity;

/**
 * Created by azazellj on 04.12.15.
 */
public class Picture extends Entity {
    public static final String FIELD_ID = "id";
    public static final String FIELD_STATUS = "status";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_ADD_DATE = "add_date";
    public static final String FIELD_PUB_DATE = "pub_date";
    public static final String FIELD_AUTHOR = "author";
    public static final String FIELD_AUTHOR_ID = "author_id";
    public static final String FIELD_IMAGE = "image";
    public static final String FIELD_THUMBNAIL = "thumbnail";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_RATING = "rating";

//    public int status; // 1 – неопублікована, 2 — опублікована, 0 — видалена
//    public String type; // picture
//    public float add_date;// дата додавання, unix time
//    public float pub_date; // дата публікації, unix time, 0 якщо status=1
//    public String author; // login або анонім
//    public int author_id; // ID автора, 0 якщо анонім
//    public String image;// картинка 400х400
//    public String thumbnail; // картинка 150х150
//    public String title; // назва картинки
//    public float rating; // рейтинг

    public String status; // 1 – неопублікована, 2 — опублікована, 0 — видалена
    public String type; // picture
    public String add_date;// дата додавання, unix time
    public String pub_date; // дата публікації, unix time, 0 якщо status=1
    public String author; // login або анонім
    public String author_id; // ID автора, 0 якщо анонім
    public String image;// картинка 400х400
    public String thumbnail; // картинка 150х150
    public String title; // назва картинки
    public String rating; // рейтинг
}
