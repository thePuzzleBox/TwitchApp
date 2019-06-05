package com.example.per2.twitchapp;

final public class GameItem {
    final private Game game;
    final private int viewers;
    final private int channels;

    public GameItem(Game game, int viewers, int channels) {
        this.game = game;
        this.viewers = viewers;
        this.channels = channels;
    }

    public Game getGame() {
        return game;
    }

    public int getViewers() {
        return viewers;
    }

    public int getChannels() {
        return channels;
    }
}
