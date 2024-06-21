package com.example.mynewapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("registerUser.jsp")
    Call<User> register(@Field("firstname")String firstname,
                        @Field("secondname")String secondname,
                        @Field("email")String email,
                        @Field("password")String password,
                        @Field("phone")String phone,
                        @Field("dob")String dob);

    @FormUrlEncoded
    @POST("login.jsp")
    Call<User> login(@Field("email")String email,
                     @Field("password")String pass);


    @GET("getPlaces.jsp")
    Call<List<Places>> getPlaces();

    @GET("getVisitingPlaces.jsp")
    Call<List<Places>> getVisitingPlaces(@Query("id") int id);

    @GET("getislands.jsp")
    Call<List<Places>> getislands();
}
