package com.rss.util.retrofitUtil;

import retrofit2.Retrofit;

public class APIUtils {
    private static final String baseUrl = "http://localhost:8080";
    private static final String addressUrl = "http://www.juso.go.kr";

    public static ReligionAPI getReligionAPI() {
        return RetrofitClient.getRssRetrofit(baseUrl).create(ReligionAPI.class);
    }

    public static SignAPI getSignAPI() {
        return RetrofitClient.getSignRetrofit(baseUrl).create(SignAPI.class);
    }
    public static AddressAPI getAddressAPI() {
        return RetrofitClient.getAddressRetrofit(addressUrl).create(AddressAPI.class);
    }
}
