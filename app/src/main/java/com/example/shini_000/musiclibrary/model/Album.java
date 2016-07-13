package com.example.shini_000.musiclibrary.model;

/**
 * Created by shini_000 on 7/12/2016.
 */
public class Album {

    private String title;
    private String artist;

    public Album(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
