package com.example.mynewapp;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.victor.loading.newton.NewtonCradleLoading;
public class MainActivity extends AppCompatActivity {
private NewtonCradleLoading newtonCradleLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newtonCradleLoading=findViewById(R.id.newton);
        newtonCradleLoading.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,india.class);
                   startActivity(intent);
            }
        }, 4000);
    }
}
