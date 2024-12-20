package com.example.apirest_android;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface TracksService {
    @POST("dsaApp/tracks")
    @Headers("Content-Type: application/json")
    Call<Tracks> addTrack(@Body Tracks t);
    @PUT("dsaApp/tracks")
    @Headers("Content-Type: application/json")
    Call<Void> updateTrack(@Body Tracks t);
}
