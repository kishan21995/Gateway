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
import com.app.gateway.models.login.LoginRequests;
import com.app.gateway.models.login.LoginResponses;
import com.app.gateway.models.signup.RegistrationRequests;
import com.app.gateway.models.signup.RegistrationResponses;
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
    private Button _logBTN;
    private TextView _forgatePWD;
    private EditText _emailET,_pwdET;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        _logBTN=findViewById(R.id.logBTN1);
        _emailET=findViewById(R.id.emailET1);
        _pwdET=findViewById(R.id.pwdET1);
        _forgatePWD=findViewById(R.id.forgatePWD1);


             _logBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        _forgatePWD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, ForgatePasswordActivity.class);
                startActivity(intent);
            }
        });


}

    private void  loginUser() {
        boolean check = true;


        String user_email = _emailET.getText().toString().trim();
        String user_pwd = _pwdET.getText().toString().trim();

        if (user_email.isEmpty()) {
            _emailET.setError("Field can't be empty");
            check = false;
        }

        if (user_pwd.isEmpty()) {
            _pwdET.setError("Field can't be empty");
            check = false;
        }

        if (check == true) {

            LoginRequests loginRequests = new LoginRequests();
            loginRequests.setEmail(user_email);
            loginRequests.setPassword(user_pwd);



            if (Utils.isInternetConnected(this)) {
                /*Utils.showProgressDialog(this);*/

                // Utils.showProgressDialog(,"Please Wait..");

                RestClient.loginUser1(loginRequests, new Callback<LoginResponses>() {
                    @Override
                    public void onResponse(Call<LoginResponses> call, Response<LoginResponses> response) {
                        //Utils.dismissProgressDialog();
                        if (response.body() != null) {
                            if (response.body()!=null ) {
                                LoginResponses loginResponses = response.body();
                                Toast.makeText(LoginActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                                HFMPrefs.putString(LoginActivity.this, Constants.LOGIN_DATA, new Gson().toJson(loginResponses));

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                //finish();


                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponses> call, Throwable t) {
                        //Utils.dismissProgressDialog();
                        Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Utils.dismissProgressDialog();
                Toast.makeText(LoginActivity.this, "Something Went wrong", Toast.LENGTH_SHORT).show();


            }

        }



    }

}