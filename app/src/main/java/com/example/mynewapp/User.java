package com.example.mynewapp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

class User implements Serializable {
    @SerializedName("response")
    String response;

    @SerializedName("name")
    String username;

    public  String getResponse(){
        return response;
    }

    public String getUsername() {
        return username;
    }
}
