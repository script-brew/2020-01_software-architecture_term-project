package com.rss.util.retrofitUtil;

import com.rss.entity.Facility;
import com.rss.reqeust.AddressModel;
import com.rss.reqeust.FacilityModel;
import com.rss.respond.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ReligionAPI {
    @POST("/registerFacility")
    Call<RegisterResponse> registerFacility(@Body FacilityModel facilityModel);

    @GET("/getFacilityByUserId")
    Call<List<FacilityModel>> requestFacilityByUserId(@Query("userId") int userId);

    @GET("/getFacilityByPos")
    Call<List<FacilityModel>> requestFacilityByPos(@Query("address") String address,
                                                   @Query("mode") int mode);

    @GET("/getFacilityByKind")
    Call<List<FacilityModel>> requestFacilityByCate(@Query("kind") String kind);

    @GET("/getFacilityByName")
    Call<List<FacilityModel>> requestFacilityByName(@Query("name") String name);

    @PUT("/updateFacility")
    Call<RegisterResponse> updateFacility(@Body FacilityModel facilityModel);

    @DELETE("/deleteFacility")
    Call<RegisterResponse> deleteFacility(@Query("facilityId") int facilityId);
}
