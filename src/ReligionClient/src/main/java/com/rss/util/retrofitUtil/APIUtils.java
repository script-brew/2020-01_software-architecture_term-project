package com.rss.util.retrofitUtil;

import retrofit2.Retrofit;

public class APIUtils {
    private static final String baseUrl = "http://localhost:8080";

    public static ReligionAPI getReligionAPI() {
        return RetrofitClient.getRssRetrofit(baseUrl).create(ReligionAPI.class);
    }

    public static SignAPI getSignAPI() {
        return RetrofitClient.getSignRetrofit(baseUrl).create(SignAPI.class);
    }
}
