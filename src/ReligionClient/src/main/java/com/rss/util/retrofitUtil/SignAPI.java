package com.rss.util.retrofitUtil;

import com.rss.reqeust.SignRequest;
import com.rss.entity.User;
import com.rss.reqeust.SignUpRequest;
import com.rss.reqeust.UserModel;
import com.rss.respond.SignResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SignAPI {

    @GET("/isEmailExist")
    Call<SignResponse> isEmailExist(@Query("email") String email);

    @POST("/signUp")
    Call<SignResponse> requestSignUp(@Body UserModel userModel);

    @POST("/signIn")
    Call<UserModel> requestSignIn(@Body SignRequest signRequest);
}
