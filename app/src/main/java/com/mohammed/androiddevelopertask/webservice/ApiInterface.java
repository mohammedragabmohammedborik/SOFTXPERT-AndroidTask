package com.mohammed.androiddevelopertask.webservice;

import com.mohammed.androiddevelopertask.home.HomeResponse;

import retrofit2.Call;

import retrofit2.http.GET;

import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/v1/cars")
    Call<HomeResponse> getHomeItems(@Query("page") int offest);

}