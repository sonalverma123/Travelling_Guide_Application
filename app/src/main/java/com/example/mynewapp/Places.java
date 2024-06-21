package com.example.mynewapp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Places implements Serializable{
    @SerializedName("place")
    String place;
    @SerializedName("image")
    String image;
    @SerializedName("description")
    String description;
    @SerializedName("islands")
    String islandsname;
    @SerializedName("islandsimages")
    String islandimage;
    @SerializedName("About")
    String about;
    @SerializedName("id")
    int id;
    @SerializedName("islandsdata")
    String islandsdata;
    @SerializedName("place_id")
    int place_id;
    @SerializedName("Lattitude")
    String lattitude;
    @SerializedName("Longitude")
    String longitude;

    public String getDescription() {
        return description;
    }

    public String getAbout() {
        return about;
    }

    public String getLattitude() {
        return lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getIslandsdata() {
        return islandsdata;
    }

    public String getPlace() {
        return place;
    }

    public String getImage() {
        return image;
    }

    public String getIslandsname(){
        return islandsname;
    }

    public String getIslandimage() {
        return islandimage;
    }

    public int getId() {
        return id;
    }
}
