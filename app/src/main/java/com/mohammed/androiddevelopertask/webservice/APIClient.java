package com.mohammed.androiddevelopertask.webservice;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public  class APIClient {

    private static APIClient mInstance;
    private Retrofit retrofit;

    private APIClient() {

      //  String language= Resources.getSystem().getConfiguration().locale.getLanguage();

        OkHttpClient client = new OkHttpClient
                .Builder()
                .connectTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(UtilityHelper.URLSERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
    public static synchronized APIClient getInstance() {
        if (mInstance == null) {
            mInstance = new APIClient();
        }
        return mInstance;
    }

    public ApiInterface apiInterface() {
        return retrofit.create(ApiInterface.class);
    }



}

