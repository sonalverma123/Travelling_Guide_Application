package com.example.mynewapp;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("ValidFragment")
public class Fragment_City extends Fragment {
    SharedPreferences preferences;
    RecyclerView cardContainer;

    int id;
    ApiInterface apiInterface;

    public Fragment_City() {
    }

    public Fragment_City(int id) {
        this.id = id;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.citydetailstab,null);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Places>> call = apiInterface.getVisitingPlaces(id);
        call.enqueue(new Callback<List<Places>>() {
            @Override
            public void onResponse(Call<List<Places>> call, Response<List<Places>> response) {
                List<Places> placesList = response.body();
                cardContainer = view.findViewById(R.id.card_container2);
                cardContainer.setLayoutManager(new LinearLayoutManager(getContext()));
                cardContainer.setAdapter(new SecondAdapter(getContext(),placesList));
            }

            @Override
            public void onFailure(Call<List<Places>> call, Throwable t) {

            }
        });
        /*cityData = new ArrayList<>();
        City2 city=new City2("Agra",R.drawable.qq);
        City2 city1 = new City2("Bikaner",R.drawable.qq);

        cityData.add(city);
        cityData.add(city1);


        cardContainer = view.findViewById(R.id.card_container2);
        cardContainer.setLayoutManager(new LinearLayoutManager(getContext()));
        cardContainer.setAdapter(new SecondAdapter(getContext(),cityData));*/

        return view;
    }
}
