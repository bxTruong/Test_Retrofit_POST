package com.example.test_retrofit_post.retrofit.api_method;

import com.example.test_retrofit_post.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface UserMethodApi {
    @POST("users")
    Call<User> createUser(@Body User user);

    @GET("users")
    Call<List<User>> getUser();

}




