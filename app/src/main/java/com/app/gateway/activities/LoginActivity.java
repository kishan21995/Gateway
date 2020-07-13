package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.app.gateway.R;
import com.app.gateway.models.login.LoginRequest;
import com.app.gateway.models.login.LoginResponse;
import com.app.gateway.retrofit.RestClient;
import com.app.gateway.utils.Constants;
import com.app.gateway.utils.HFMPrefs;
import com.app.gateway.utils.Utils;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button _logBTN4;
    private TextView _forgatePWD;
    private EditText _emailET4,_pwdET4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();


        _logBTN4=findViewById(R.id.logBTN4);
        _emailET4=findViewById(R.id.emailET4);
        _pwdET4=findViewById(R.id.pwdET4);
        _forgatePWD=findViewById(R.id.forgatePWD1);


             _logBTN4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //loginUser();
                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });




}

    private void initView() {
        //initialView();
        //setPagerAdapter();
        // setPagerIndicator();
        //setOnClickListenerLoginButton();
         //setOnClickListenerFogatePassword();
    }




    /*public void  loginUser() {
        boolean check = true;


        String user_email = _emailET4.getText().toString().trim();
        String user_pwd = _pwdET4.getText().toString().trim();

        if (user_email.isEmpty()) {
            _emailET4.setError("Field can't be empty");
            check = false;
        }

        if (user_pwd.isEmpty()) {
            _pwdET4.setError("Field can't be empty");
            check = false;
        }

        if (check == true) {

            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setEmail(user_email);
            loginRequest.setPassword(user_pwd);



            if (Utils.isInternetConnected(this)) {
                Utils.showProgressDialog(this);

                RestClient.loginUser(loginRequest, new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        //Utils.dismissProgressDialog();
                        if (response.body() != null) {
                            if (response.body().getStatus()==true) {
                                LoginResponse loginResponse = response.body();
                                Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                HFMPrefs.putString(LoginActivity.this, Constants.LOGIN_DATA, new Gson().toJson(loginResponse));

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                               *//* intent.putExtra("USERNAME", "gmaii");
                                intent.putExtra("PASSWORD", "password");*//*



                                startActivity(intent);
                                finish();


                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        //Utils.dismissProgressDialog();
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                //Utils.dismissProgressDialog();
                Toast.makeText(LoginActivity.this, "Please Check Internet Connection", Toast.LENGTH_SHORT).show();


            }

        }



    }*/



}