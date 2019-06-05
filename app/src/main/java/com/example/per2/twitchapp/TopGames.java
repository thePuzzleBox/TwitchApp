package com.example.per2.twitchapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

final public class TopGames {
    @SerializedName("_total")
    final private int total;
    @SerializedName("_links")
    final private Links links;
    @SerializedName("top")
    final private List<GameItem> gameItemList;

    public TopGames(int total, Links links, List<GameItem> gameItemList) {
        this.total = total;
        this.links = links;
        this.gameItemList = gameItemList;
    }

    public int getTotal() {
        return total;
    }

    public Links getLinks() {
        return links;
    }

    public List<GameItem> getGameItemList() {
        return gameItemList;
    }
}
