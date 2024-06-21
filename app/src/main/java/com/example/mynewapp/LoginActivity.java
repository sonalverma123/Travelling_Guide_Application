package com.example.mynewapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText email, pass;
    ImageView top_curve;
    TextView email_text, pass_text, login_title;
    TextView logo;
    CardView login_card;
    int i=0;
    Database database;
    Button login, joinus;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database = new Database(this);
        top_curve = findViewById(R.id.top_curve);
        email_text = findViewById(R.id.email_text);
        pass_text = findViewById(R.id.pass_text);
        logo = findViewById(R.id.logo);
        login_title = findViewById(R.id.login_title);
        login_card = findViewById(R.id.login_card);
        email = findViewById(R.id.login_email);
        pass = findViewById(R.id.login_pass);
        login = findViewById(R.id.login_login);
        joinus = findViewById(R.id.sign_in);
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);

        Animation top_curve_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_down);
        top_curve.startAnimation(top_curve_anim);

        Animation editText_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.edittext_anim);
        email.startAnimation(editText_anim);
        pass.startAnimation(editText_anim);

        Animation field_name_enim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.field_name_anim);
        email_text.startAnimation(field_name_enim);

        pass_text.startAnimation(field_name_enim);
        logo.startAnimation(field_name_enim);
        login_title.startAnimation(field_name_enim);
        Animation center_reveal_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.center_reveal_anim);
        login_card.startAnimation(center_reveal_anim);

        Animation new_user_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_top);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e, p;
                e = email.getText().toString();
                p = pass.getText().toString();

                if (e.trim().length() == 0 || p.trim().length() == 0) {
                    email.setError("Don't leave blank");
                    return;
                }
                Call<User> call = apiInterface.login(e, p);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User user = response.body();
                        if (user.getResponse().equals("success")) {
                            Intent intent = new Intent(LoginActivity.this, DrawerActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }
        });

        joinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SigninActivity.class);
                startActivity(i);
            }
        });

    }


    @Override
    public void onBackPressed() {
        i++;
        if (i == 2)
            System.exit(0);
        else {
            Toast.makeText(this, "press one more time to exit", Toast.LENGTH_SHORT).show();
        }


    }

}