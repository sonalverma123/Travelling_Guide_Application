package com.example.mynewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class aboutislands extends AppCompatActivity {

    ImageView image;
    TextView name;
    TextView about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutislands);
        init();
        Intent intent=getIntent();
    Places places= (Places) intent.getSerializableExtra("visit_island");
        name.setText(places.getIslandsname());
        about.setText(places.getIslandsdata());
        Picasso.get().load(places.getIslandimage()).into(image);
    }

    private void init() {

        image=findViewById(R.id.islands_image);
        name=findViewById(R.id.islandhead);
        about=findViewById(R.id.island_desc);
    }
}
