package com.example.mynewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class islandsActivity extends AppCompatActivity {
    RecyclerView cardContainer;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islands);
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Places>> call = apiInterface.getislands();
        call.enqueue(new Callback<List<Places>>() {
            @Override
            public void onResponse(Call<List<Places>> call, Response<List<Places>> response) {
                List<Places> placesList = response.body();
                cardContainer = findViewById(R.id.card_container3);
                cardContainer.setLayoutManager(new LinearLayoutManager(islandsActivity.this));
                cardContainer.setAdapter(new islandsAdapter(islandsActivity.this, placesList));
            }

            @Override
            public void onFailure(Call<List<Places>> call, Throwable t) {

            }
        });
    }
}
