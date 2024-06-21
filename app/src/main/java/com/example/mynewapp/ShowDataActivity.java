package com.example.mynewapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ShowDataActivity extends AppCompatActivity {
    TextView name, email, dob, phone;
    Database helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        name = findViewById(R.id.profile_name);
        email = findViewById(R.id.profile_country);
        dob = findViewById(R.id.profile_city);
        phone = findViewById(R.id.profile_state);
        helper = new Database(this);
        Cursor cursor = helper.getProfile("2000sonalverma@gmail.com");


        StringBuffer sb = new StringBuffer();
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToNext()) {
                name.setText(cursor.getString(1) + " " + cursor.getString(2));
                email.setText(cursor.getString(5));
                dob.setText(cursor.getString(4));
                phone.setText(cursor.getString(6));
                /*sb.append("firstname" + cursor.getString(1) + "\n");
                sb.append("secondname" + cursor.getString(2) + "\n");
                sb.append("password" + cursor.getString(3) + "\n");
                sb.append("dob" + cursor.getString(4) + "\n");
                sb.append("email" + cursor.getString(5) + "\n");
                sb.append("phone" + cursor.getString(6) + "\n");*/
            }
            // name.setText(sb.toString());
            //email.setText(sb.toString());
            //dob.setText(sb.toString());
            //phone.setText(sb.toString());

        } else
            Toast.makeText(this, "no data present", Toast.LENGTH_SHORT).show();

    }
}





