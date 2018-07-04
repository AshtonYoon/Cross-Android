package com.support.android.designlibdemo.Connector;

import com.support.android.designlibdemo.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface FriendService {

    @GET("search/account/:type")
    Call<List<User>> searchFriends(@Query("text") String text);

    @GET("friend")
    Call<List<User>> getFriends();

    @PUT("friend")
    Call<Void> addFriend(@Body String uid);

    @DELETE("friend")
    Call<Void> deleteFriend(@Body String uid);
}
