package com.example.per2.twitchapp;

import com.google.gson.annotations.SerializedName;

final public class Game {
    final private String name;
    final private ImageUrls box;
    final private ImageUrls logo;
    @SerializedName("_id")
    final private String id;
    @SerializedName("giantbomb_id")
    final private String giantBombId;

    public Game(String name, ImageUrls box, ImageUrls logo, String id, String giantBombId) {
        this.name = name;
        this.box = box;
        this.logo = logo;
        this.id = id;
        this.giantBombId = giantBombId;
    }

    public String getName() {
        return name;
    }

    public ImageUrls getBox() {
        return box;
    }

    public ImageUrls getLogo() {
        return logo;
    }

    public String getId() {
        return id;
    }

    public String getGiantBombId() {
        return giantBombId;
    }
}
