package com.azazellj.testapp.api;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by azazellj on 22.03.16.
 */
public class ApiInterceptor implements Interceptor {
    private static final String PARAM_API_KEY = "client";
    private static final String VALUE_API_KEY = "720500bc74f719e5";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url().newBuilder().addQueryParameter(PARAM_API_KEY, VALUE_API_KEY).build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
