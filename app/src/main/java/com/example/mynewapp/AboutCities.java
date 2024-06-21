package com.example.mynewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class AboutCities extends AppCompatActivity {
ImageView img;
TextView about;
TextView head;
Button map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_cities);
init();
        Intent intent=getIntent();
        final Places places= (Places) intent.getSerializableExtra("visit_place");

        about.setText(places.getDescription());
        head.setText(places.getPlace());
        Picasso.get().load(places.getImage()).into(img);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AboutCities.this,MapActivity.class);
                intent.putExtra("data",places);
                startActivity(intent);
            }
        });

    }

    private void init() {
        about=findViewById(R.id.visit_desc);
        img=findViewById(R.id.visit_image);
        head=findViewById(R.id.head);
        map=findViewById(R.id.btndemo);


    }
}
