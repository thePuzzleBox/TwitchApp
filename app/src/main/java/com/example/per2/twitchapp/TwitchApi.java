package com.example.per2.twitchapp;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface TwitchApi {

    @Headers({
            "Client-ID: nj711fd62beyto4o11yomn1lb6os6z",

    })

    @GET("games/top")
    Call<TopGames> getTopGames(@Query("limit") Integer limit, @Query("offset") Integer offset);

}
