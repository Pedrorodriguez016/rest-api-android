package com.example.apirest_android;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.os.Bundle;

public class UpdateTrack extends AppCompatActivity {
    EditText titleText;
    EditText singerText;
    public static final String BASE_URI = "http://10.0.2.2:8080/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);
        titleText = findViewById(R.id.updateTText);
        singerText = findViewById(R.id.UpdateSText);

    }
    public void UpdateTrackonClick(View v) {
        String title = titleText.getText().toString();
        String singer = singerText.getText().toString();
        Tracks t = new Tracks(title,singer);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URI)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TracksService register = retrofit.create(TracksService.class);
        Call<Void> call = register.updateTrack(t);
        String respuesta = null;

        call.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if (response.isSuccessful()) {

                    Toast.makeText(UpdateTrack.this, "Cancion actualizada", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(UpdateTrack.this, "No se pudo actualizar", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast.makeText(UpdateTrack.this, "Error de network:" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }

        })
        ;}
}

