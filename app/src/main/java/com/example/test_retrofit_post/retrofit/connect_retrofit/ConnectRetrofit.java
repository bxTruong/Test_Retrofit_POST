package com.example.test_retrofit_post.retrofit.connect_retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectRetrofit {

    public static Retrofit createRetrofit(String urrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       return retrofit;
    }



}
