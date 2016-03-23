package com.azazellj.testapp.api;

import com.azazellj.testapp.entity.Picture;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by azazellj on 22.03.16.
 */
public class UkrBashApi {
    private static UkrBashApi instance;
    protected UkrBashService mService;

    public static UkrBashApi getInstance() {
        if (instance == null) {
            instance = new UkrBashApi();
        }

        return instance;
    }

    private UkrBashApi() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.ukrbash.org/")
                .client(UkrBashHttpClient.get())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = mRetrofit.create(UkrBashService.class);
    }

    public void getRandomPictures(Callback<List<Picture>> callback) {
        mService.getRandomPictures().enqueue(callback);
    }

    public void getPicturesWithLimit(int limit, Callback<List<Picture>> callback) {
        mService.getPicturesWithLimit(limit).enqueue(callback);
    }

    public void getOnePicture(Callback<List<Picture>> callback) {
        getPicturesWithLimit(1, callback);
    }
}
