package com.example.api_ex_retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface My_Api {

    @GET("posts")
    Call<List<Post_model>> getmodels();

}
