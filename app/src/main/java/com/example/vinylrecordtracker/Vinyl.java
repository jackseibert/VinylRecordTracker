package com.example.vinylrecordtracker;

import java.io.Serializable;

/**
 * Created by tgibbons on 4/24/2018.
 */


public class Vinyl implements Serializable {
    private String key;
    private String species;
    private String weightInOz;
    private String dateCaught;
    private String locationCaughtLatitude;
    private String locationCaughtLongitude;

    public Fish() {
    }

    public Fish(String key, String species, String weightInOz, String dateCaught, String locationCaughtLatitude, String locationCaughtLongitude) {
        this.key = key;
        this.species = species;
        this.weightInOz = weightInOz;
        this.dateCaught = dateCaught;
        this.locationCaughtLatitude = locationCaughtLatitude;
        this.locationCaughtLongitude = locationCaughtLongitude;
    }

    public Fish(String species, String weightInOz, String dateCaught, String locationCaughtLatitude, String locationCaughtLongitude) {
        this.species = species;
        this.weightInOz = weightInOz;
        this.dateCaught = dateCaught;
        this.locationCaughtLatitude = locationCaughtLatitude;
        this.locationCaughtLongitude = locationCaughtLongitude;
    }

    public Fish(String key, String species, String weightInOz, String dateCaught) {
        this.key = key;
        this.species = species;
        this.weightInOz = weightInOz;
        this.dateCaught = dateCaught;
        this.locationCaughtLatitude = locationCaughtLatitude;
        this.locationCaughtLongitude = locationCaughtLongitude;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getWeightInOz() {
        return weightInOz;
    }

    public void setWeightInOz(String weightInOz) {
        this.weightInOz = weightInOz;
    }

    public String getDateCaught() {
        return dateCaught;
    }

    public void setDateCaught(String dateCaught) {
        this.dateCaught = dateCaught;
    }

    public String getLocationCaughtLatitude() {
        return locationCaughtLatitude;
    }

    public void setLocationCaughtLatitude(String locationCaughtLatitude) {
        this.locationCaughtLatitude = locationCaughtLatitude;
    }

    public String getLocationCaughtLongitude() {
        return locationCaughtLongitude;
    }

    public void setLocationCaughtLongitude(String locationCaughtLongitude) {
        this.locationCaughtLongitude = locationCaughtLongitude;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "species='" + species + '\'' +
                ", weightInOz='" + weightInOz + '\'' +
                ", dateCaught='" + dateCaught + '\'' +
                '}';
    }
}