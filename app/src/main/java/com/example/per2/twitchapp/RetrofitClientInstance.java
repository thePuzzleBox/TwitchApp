package com.example.per2.twitchapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    public static TwitchApi createTwitchService() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.twitch.tv/helix/");

        return builder.build().create(TwitchApi.class);
    }
}
