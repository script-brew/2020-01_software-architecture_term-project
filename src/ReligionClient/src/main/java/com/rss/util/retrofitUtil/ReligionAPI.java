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

    @GET("/getFacilityAll")
    Call<List<FacilityModel>> requestFacilityAll();

    @GET("/getFacilityByPos")
    Call<List<FacilityModel>> requestFacilityByPos(@Body AddressModel addressModel);

    @GET("/getFacilityByCate")
    Call<List<FacilityModel>> requestFacilityByCate(@Query("category") String category);

    @GET("/getFacilityByName")
    Call<List<FacilityModel>> requestFacilityByName(@Query("name") String name);

    @PUT("/updateFacility")
    Call<RegisterResponse> updateFacility(@Body FacilityModel facilityModel);

    @DELETE("/removeFacility")
    Call<RegisterResponse> removeFacility(@Query("facilityId") int facilityId);
}
