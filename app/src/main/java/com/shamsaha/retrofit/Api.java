package com.shamsaha.retrofit;


import com.shamsaha.victim.model.HomeModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("home")
    Call<HomeModel> HOME_MODEL_CALL (@Field("language") String language);




}