package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.gateway.R;
import com.app.gateway.models.signup.RegistrationRequests;
import com.app.gateway.models.signup.RegistrationResponses;
import com.app.gateway.retrofit.RestClient;
import com.app.gateway.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    private TextView _signupTXT;
    private EditText _nameEditText, _emailEditText, _mobileEditText, _addressEditText, _pwdEditText;

    private Button _signupBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        _nameEditText = findViewById(R.id.nameET2);
        _emailEditText = findViewById(R.id.emailET2);
        _pwdEditText = findViewById(R.id.pwdET2);
        _addressEditText = findViewById(R.id.addressET2);
        _mobileEditText = findViewById(R.id.mobileET2);


        _signupBTN = findViewById(R.id.signupBTN2);

        _signupTXT = findViewById(R.id.signupTXT2);


        _signupTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        _signupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signUpUser();
            }
        });
    }


    private void  signUpUser() {
        boolean check = true;

        String user_name = _nameEditText.getText().toString().trim();
        String user_email = _emailEditText.getText().toString().trim();
        String user_pwd = _pwdEditText.getText().toString().trim();
        String user_address = _addressEditText.getText().toString().trim();
        String user_mobile = _mobileEditText.getText().toString().trim();



        if (user_name.isEmpty()) {
            _nameEditText.setError("Field can't be empty");
            check = false;

        }

        if (user_email.isEmpty()) {
            _emailEditText.setError("Field can't be empty");
            check = false;

        }

        if (user_pwd.isEmpty()) {
            _pwdEditText.setError("Field can't be empty");
            check = false;

        }


        if (user_address.isEmpty()) {
            _addressEditText.setError("Field can't be empty");
            check = false;

        }
        if (user_mobile.isEmpty()) {
            _mobileEditText.setError("Field can't be empty");
            check = false;

        }

        if (check == true) {
           // userId = HFMPrefs.getString(SignupActivity.this, Constants.USER_ID);
           RegistrationRequests registrationRequests = new RegistrationRequests();
            registrationRequests.setUsername(user_name);
            registrationRequests.setEmail(user_email);
            registrationRequests.setPassword(user_pwd);
            registrationRequests.setAddress(user_address);
            registrationRequests.setMobile(user_mobile);


            if (Utils.isInternetConnected(this)) {
                Utils.showProgressDialog(this);


                RestClient.signupUser(registrationRequests, new Callback<RegistrationResponses>() {
                    @Override
                    public void onResponse(Call<RegistrationResponses> call, Response<RegistrationResponses> response) {
                        Utils.dismissProgressDialog();
                        if (response.body() != null) {
                            if (response.body().getStatus() ==true) {
                                RegistrationResponses registrationResponses = response.body();
                                Toast.makeText(SignupActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                                //HFMPrefs.putString(SignupActivity.this, Constants.LOGIN_DATA, new Gson().toJson(registrationResponses));

                                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                                startActivity(intent);
                                //finish();


                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<RegistrationResponses> call, Throwable t) {
                        Utils.dismissProgressDialog();
                        Toast.makeText(SignupActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Utils.dismissProgressDialog();
                Toast.makeText(SignupActivity.this, "Please Check Internet Connection", Toast.LENGTH_SHORT).show();


            }

        }



    }

    /*public  void signUpUser(){
        String user_name = _nameET.getText().toString().trim();
        String user_email = _emailET.getText().toString().trim();
        String user_pwd = _pwdET.getText().toString().trim();
        String user_address = _addressET.getText().toString().trim();
        String user_mobile = _mobileET.getText().toString().trim();


        final RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setUsername(user_name);
        registrationRequest.setEmail(user_email);
        registrationRequest.setPassword(user_pwd);
        registrationRequest.setAddress(user_address);
        registrationRequest.setMobile(user_mobile);




        Utils.showProgressDialog(getApplicationContext(),"");
        RestClient.signupUser(registrationRequest, new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                if(response != null){

                    if(response.body() != null){

                        if(response.body().getStatus()){

                            Toast.makeText(SignupActivity.this, "Successfull", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                          *//*intent.putExtra("name", user_name);
                          intent.putExtra("email", user_password);*//*

                            intent.putExtra("USERNAME", "user_name");
                            intent.putExtra("EMAIL", "user_email");
                            intent.putExtra("PASSWORD", "user_pwd");
                            intent.putExtra("ADDRESS", "user_address");
                            intent.putExtra("MOBILE", "user_mobile");




                            startActivity(intent);


                        }else {

                            Toast.makeText(SignupActivity.this, "Fail", Toast.LENGTH_SHORT).show();

                        }


                    }
                }

            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Utils.dismissProgressDialog();
                Toast.makeText(SignupActivity.this, "api failure", Toast.LENGTH_SHORT).show();
            }
        });






    }*/
}