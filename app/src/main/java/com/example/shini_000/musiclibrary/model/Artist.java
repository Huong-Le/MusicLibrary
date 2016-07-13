package com.example.shini_000.musiclibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shini_000 on 7/12/2016.
 */
public class Artist implements Parcelable{

    private int imageArtist;
    private String NameArtist;
    private  String link;

    public Artist(int imageArtist, String NameArtist, String link) {
        this.imageArtist = imageArtist;
        this.NameArtist = NameArtist;
        this.link = link;
    }

    protected Artist(Parcel in) {
        imageArtist = in.readInt();
        NameArtist = in.readString();
        link = in.readString();
    }

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };

    public int getImageArtist() {
        return imageArtist;
    }

    public void setImageArtist(int imageArtist) {
        this.imageArtist = imageArtist;
    }

    public String getTxtNameArtist() {
        return NameArtist;
    }

    public void setNameArtist(String NameArtist) {
        this.NameArtist = NameArtist;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNameArtist() {
        return NameArtist;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageArtist);
        dest.writeString(NameArtist);
        dest.writeString(link);
    }
}
