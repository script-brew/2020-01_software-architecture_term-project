package com.rss.util.retrofitUtil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit rss_retrofit = null;
    private static Retrofit signRetrofit = null;
    private static Retrofit addressRetrofit = null;

    public static Retrofit getRssRetrofit(String baseUrl) {
        if(rss_retrofit == null) {
            rss_retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return rss_retrofit;
    }

    public static Retrofit getSignRetrofit(String baseUrl) {
        if(signRetrofit == null) {
            signRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return signRetrofit;
    }

    public static Retrofit getAddressRetrofit(String baseUrl) {
        if(addressRetrofit == null) {
            addressRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return addressRetrofit;
    }
}
