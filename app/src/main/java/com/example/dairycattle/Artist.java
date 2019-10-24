package com.example.dairycattle;

public class Artist {

    String artistId;
    String artistName;
    String artistGender;

    public Artist(){


    }

    public Artist(String artistId, String artistName, String artistGender) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistGender = artistGender;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistGender() {
        return artistGender;
    }
}
