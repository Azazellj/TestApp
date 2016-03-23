package com.azazellj.testapp.api;

import okhttp3.OkHttpClient;

/**
 * Created by azazellj on 22.03.16.
 */
public class UkrBashHttpClient {

    public static OkHttpClient get() {
        return new OkHttpClient.Builder().addInterceptor(new ApiInterceptor()).build();
    }
}
