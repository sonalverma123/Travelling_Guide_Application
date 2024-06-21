package com.example.mynewapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SigninActivity extends AppCompatActivity {

    int i = 0;
    ImageView top_curve;
    TextView logo;
    TextView regsitration_title, firstname_text,secondname_text , email_text, pass_text, repass_text,dob_text, Phone_text  ;
    CardView login_card;
    EditText firstname, secondname, password, repassword, dob, email, phn;
    Button signin ;
    Button login;
    Database helper;
    ApiInterface apiInterface;
    ApiClient apiClient;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        init();
        awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tfirstname, tsecondname, tpassword, trepassword, tdob, temail, tphn;
                tfirstname = firstname.getText().toString();
                tsecondname = secondname.getText().toString();
                tpassword = password.getText().toString();
                trepassword = repassword.getText().toString();
                tdob = dob.getText().toString();
                temail = email.getText().toString();
                tphn = phn.getText().toString();

                if (tsecondname.trim().length() == 0) {
                    secondname.setError("don't leave blank");
                    return;
                } else if (tpassword.trim().length() == 0) {
                    password.setError("don't leave blank");
                    return;
                } else if (temail.trim().length() == 0) {
                    email.setError("don't leave blank");
                    return;
                } else if (trepassword.trim().length() == 0) {
                    repassword.setError("don't leave blank");
                    return;
                } else if (tdob.trim().length() == 0) {
                    dob.setError("don't leave blank");
                    return;
                } else if (tphn.trim().length() == 0) {
                    phn.setError("don't leave blank");
                    return;
                } else if (tfirstname.trim().length() == 0) {
                    firstname.setError("don't leave blank");
                    return;
                }
                Call<User> call=apiInterface.register(tfirstname,tsecondname,temail,tpassword,tphn,tdob);
                call.enqueue(new Callback<User>(){
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                       User user=response.body();
                       if(user.getResponse().equals("success")){
                           firstname.setText("");
                           secondname.setText("");
                           email.setText("");
                           password.setText("");
                           dob.setText("");
                           phn.setText("");
                           repassword.setText("");

                           Toast.makeText(SigninActivity.this,"user registered successfully",Toast.LENGTH_SHORT).show();
                       }
                       else{
                           Toast.makeText(SigninActivity.this,"Check Code",Toast.LENGTH_SHORT).show();
                       }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(SigninActivity.this,"Check Code"+t,Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(SigninActivity.this,LoginActivity.class);
        startActivity(intent);
    }
});

    }


    private void init() {
        firstname = findViewById(R.id.Signin_firstname);
        secondname = findViewById(R.id.Signin_secondname);
        password = findViewById(R.id.signin_pass);
        repassword = findViewById(R.id.signin_repass);
        dob = findViewById(R.id.Signin_dob);
        email = findViewById(R.id.Signin_Email);
        phn = findViewById(R.id.Signin_Phone);
        signin = findViewById(R.id.sign_in);
        login=findViewById(R.id.getUserData);
        top_curve = findViewById(R.id.top_curve);
        logo = findViewById(R.id.logo);
        login_card = findViewById(R.id.login_card);
        regsitration_title= findViewById(R.id.registration_title);
                firstname_text= findViewById(R.id.firstname_text);
                        secondname_text=findViewById(R.id.secondname_text);
                                email_text= findViewById(R.id.email_text);
                                        pass_text= findViewById(R.id.pass_text);
                                                repass_text= findViewById(R.id.repass_text);
                                                        dob_text=findViewById(R.id.dob_text);
                                                                Phone_text=findViewById(R.id.Phone_text);



        Animation top_curve_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_down);
        top_curve.startAnimation(top_curve_anim);

        Animation editText_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.edittext_anim);
        email.startAnimation(editText_anim);
        password.startAnimation(editText_anim);
        firstname.startAnimation(editText_anim);
        secondname.startAnimation(editText_anim);
        repassword.startAnimation(editText_anim);
        dob.startAnimation(editText_anim);
        phn.startAnimation(editText_anim);


        Animation field_name_enim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.field_name_anim);
        email_text.startAnimation(field_name_enim);
        firstname_text.startAnimation(field_name_enim);
        secondname_text.startAnimation(field_name_enim);
        pass_text.startAnimation(field_name_enim);
        repass_text.startAnimation(field_name_enim);
        dob_text.startAnimation(field_name_enim);
        Phone_text.startAnimation(field_name_enim);


        pass_text.startAnimation(field_name_enim);
        logo.startAnimation(field_name_enim);
        regsitration_title.startAnimation(field_name_enim);
        Animation center_reveal_anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.center_reveal_anim);
        login_card.startAnimation(center_reveal_anim);

        Animation new_user_anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down_top);

        helper=new Database(this);
    }
}
