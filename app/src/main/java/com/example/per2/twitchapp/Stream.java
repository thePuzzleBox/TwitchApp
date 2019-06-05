package com.example.per2.twitchapp;

public class Stream {
    private String[] community_ids;
    private String title;
    private String user_name;
    private String game_id;
    private String id;
    private String thumbnail_url;
    private int viewer_count;

    public Stream (String[] community_ids, String title, String user_name, String game_id, String id, String thumbnail_url, int viewer_count){

        this.community_ids = community_ids;
        this.title = title;
        this.user_name = user_name;
        this.game_id =game_id;
        this.thumbnail_url =thumbnail_url;
        this.viewer_count = viewer_count;
    }

    public String[] getCommunity_ids() {
        return community_ids;
    }

    public String getTitle() {
        return title;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getGame_id() {
        return game_id;
    }

    public String getId() {
        return id;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public int getViewer_count() {
        return viewer_count;
    }

}
