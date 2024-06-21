package com.example.mynewapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ListView;
import android.support.v7.widget.SearchView;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrawerActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences preferences;
    RecyclerView cardContainer;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ghumo Phiro");

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Places>> call = apiInterface.getPlaces();
        call.enqueue(new Callback<List<Places>>() {
            @Override
            public void onResponse(Call<List<Places>> call, Response<List<Places>> response) {
                List<Places> placesList = response.body();
                cardContainer = findViewById(R.id.card_container);
                cardContainer.setLayoutManager(new LinearLayoutManager(DrawerActivity.this));
                cardContainer.setAdapter(new RVadapter(DrawerActivity.this, placesList));
            }

            @Override
            public void onFailure(Call<List<Places>> call, Throwable t) {

            }
        });
        /*cityyy = new ArrayList<>();
        City city = new City("Jaipur", R.drawable.qq);
        City city1 = new City("Bikaner", R.drawable.qq);
        City city3 = new City("Delhi", R.drawable.qq);
        City city4 = new City("Agra", R.drawable.qq);
        City city5 = new City("Ajmer", R.drawable.qq);
        City city6 = new City("Rajasthan", R.drawable.qq);
        City city7 = new City("Rajasthan", R.drawable.qq);

        cityyy.add(city);
        cityyy.add(city1);
        cityyy.add(city3);
        cityyy.add(city4);
        cityyy.add(city5);
        cityyy.add(city6);
        cityyy.add(city7);
        cardContainer = findViewById(R.id.card_container);
        cardContainer.setLayoutManager(new LinearLayoutManager(this));
        cardContainer.setAdapter(new RVadapter(this, cityyy));
*/

        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        //MenuItem searchViewItem = menu.findItem(R.id.mi_search);
        //final SearchView searchViewAndroidActionBar = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        //searchViewAndroidActionBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
          //  @Override
           // public boolean onQueryTextSubmit(String query) {
             //   searchViewAndroidActionBar.clearFocus();
               // return true;
            //}

            //@Override
            //public boolean onQueryTextChange(String newText) {
              //  return false;
            //}
        //});
   return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       // if (id == R.id.nav_home) {

        //}
         if (id == R.id.nav_city) {

        } else if (id == R.id.nav_login) {
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_islands) {
             Intent intent = new Intent(this, islandsActivity.class);
             startActivity(intent);

         }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}




