package com.rss.util.retrofitUtil;

import com.rss.respond.AddressBody;
import com.rss.respond.AddressFormat;
import com.rss.respond.RespondFormat;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AddressAPI {
    @GET("/addrlink/addrLinkApi.do")
    Call<RespondFormat> getAddress(@Query("currentPage") int currentPage,
                                   @Query("countPerPage") int countPage,
                                   @Query("keyword") String keyword,
                                   @Query("confmKey") String key,
                                   @Query("resultType") String resultType);
}