package com.support.android.designlibdemo.Connector;

import com.support.android.designlibdemo.Connector.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {

    @FormUrlEncoded
    @POST("signin/fb")
    Call<User> signin(@Field("accessToken") String accessToken);
}
