package com.example.per2.twitchapp;


public class Streamer {

    private String display_name;
    private String description;
    private String url;
    private String profile_img_url;
    private String offline_img_url;
    private int view_count;

    public Streamer(String display_name, String description, String url, String profile_img_url, String offline_img_url, int view_count){

        this.display_name = display_name;
        this.description = description;
        this.url = url;
        this.profile_img_url = profile_img_url;
        this.offline_img_url = offline_img_url;
        this.view_count = view_count;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getProfile_img_url() {
        return profile_img_url;
    }

    public String getOffline_img_url() {
        return offline_img_url;
    }

    public int getView_count() {
        return view_count;
    }

}
