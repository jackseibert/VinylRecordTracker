package com.example.vinylrecordtracker;

import java.io.Serializable;


public class Vinyl implements Serializable {
    private String key;
    private String artist;
    private String albumName;
    private String condition;
    private String dateBought;
    private String price;
    private String otherNotes;

    public Vinyl() {
    }

    //Constructor for Vinyl variables
    public Vinyl(String key, String artist, String albumName, String condition, String dateBought, String price, String otherNotes) {
        this.key = key;
        this.artist = artist;
        this.albumName = albumName;
        this.condition = condition;
        this.dateBought = dateBought;
        this.price = price;
        this.otherNotes = otherNotes;
    }

    //Get and Set methods for all String variables.
    public String getKey() { return key; }

    public void setKey(String key) { this.key = key; }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDateBought() {
        return dateBought;
    }

    public void setDateBought(String dateBought) {
        this.dateBought = dateBought;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOtherNotes() {
        return otherNotes;
    }

    public void setOtherNotes(String otherNotes) {
        this.otherNotes = otherNotes;
    }

    @Override
    public String toString() {
        return "Vinyl{" +
                "artist='" + artist + '\'' +
                ", albumName='" + albumName + '\'' +
                ", condition='" + condition + '\'' +
                ", dateBought='" + dateBought + '\'' +
                ", price='" + price + '\'' +
                ", otherNotes='" + otherNotes + '\'' +
                '}';
    }

}