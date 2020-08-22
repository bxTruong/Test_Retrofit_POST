package com.example.test_retrofit_post.retrofit.call_api;

import com.example.test_retrofit_post.retrofit.api_method.UserMethodApi;
import com.example.test_retrofit_post.model.User;
import com.example.test_retrofit_post.retrofit.connect_retrofit.ConnectRetrofit;

import java.util.List;

import retrofit2.Call;

public class UserCallApi {
//"https://jsonplaceholder.typicode.com/users"
    private static String url_user = "https://jsonplaceholder.typicode.com/";
    private static ConnectRetrofit connectRetrofit;
    private static UserMethodApi userMethodApi = connectRetrofit
            .createRetrofit(url_user)
            .create(UserMethodApi.class);

    public static Call<User> createUser(final User user) {
        Call<User> call = userMethodApi.createUser(user);
        return call;
    }

    public static Call<List<User>> getUser() {
        Call<List<User>> call = userMethodApi.getUser();
        return call;
    }
}
