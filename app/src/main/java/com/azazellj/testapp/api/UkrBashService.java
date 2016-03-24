package com.azazellj.testapp.api;

import com.azazellj.testapp.entity.Picture;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by azazellj on 22.03.16.
 */
public interface UkrBashService {
    @GET("1/pictures.getRandom.json")
    Call<List<Picture>> getRandomPictures();

    @GET("1/pictures.getRandom.json")
    Call<List<Picture>> getPicturesWithLimit(@Query("limit") int limit);
}
